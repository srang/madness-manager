package com.github.srang.madness.service;

import com.github.srang.madness.model.entities.Bracket;
import com.github.srang.madness.model.entities.Game;
import com.github.srang.madness.model.entities.Team;
import com.github.srang.madness.model.forms.BracketForm;
import com.github.srang.madness.model.forms.CreateMasterBracketForm;
import com.github.srang.madness.model.forms.GameTouple;
import com.github.srang.madness.model.repositories.BracketRepository;
import com.github.srang.madness.model.repositories.GameRepository;
import com.github.srang.madness.model.repositories.TeamRepository;
import com.github.srang.madness.model.repositories.UserRepository;
import com.github.srang.madness.model.types.Region;
import com.github.srang.madness.model.types.Round;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static com.github.srang.madness.model.types.Round.*;
import static java.util.stream.Collectors.*;

/**
 * Created by srang on 12/17/16.
 */
@Log
@Service
public class BracketService {
    @Autowired
    BracketRepository bracketRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TeamRepository teamRepository;
    @Autowired
    GameRepository gameRepository;
    @Autowired
    TeamService teamService;
    @Autowired
    GameService gameService;

    @Value("${org.srang.madness.region.size}")
    Integer regionSize;


//    public List<Integer> generateMatchups() {
//        List<Integer> firstTeams = new LinkedList<>(Arrays.asList(1,2,3,4,5,6,7,8));
//        List<Integer> ret = new ArrayList<>();
//        int count = firstTeams.size();
//        while(count > 1) {
//            if((count + 1 ) % 2 == 1) {
//                ret.add(0, firstTeams.remove(1));
//            } else {
//                ret.add(0, firstTeams.remove(count - 2));
//            }
//            count -= 1;
//            log.warning("count: " + count);
//        }
//        ret.add(0, firstTeams.remove(0));
//
//        return ret;
//    }

    public List<Integer> generateMatchups() {
        return Arrays.asList(1, 8, 5, 4, 6, 3, 7, 2);
    }

    public Bracket getMaster() {
        return bracketRepository.findMasterBracket();
    }

    public List<Region> regions() {
        return Arrays.asList(Region.RegionType.REGION_A, Region.RegionType.REGION_B, Region.RegionType.REGION_C, Region.RegionType.REGION_D).stream()
                .map(Region.RegionType::region).collect(toList());
    }

    public List<Game> getRound(Bracket bracket, Round round) {
        return gameRepository.findByBracketAndRound(bracket, round.id());
    }

    public List<Integer> getRoundRegionGameIds(Round round, Region.RegionType region) {
        Integer regionRoundSize = round.games() / 4;
        Integer start = 1 + (region.getId() - 1) * regionRoundSize;
        Integer end = start + regionRoundSize;
        return IntStream.range(start, end).boxed().collect(toList());
    }

    public List<Round> rounds() {
        return Arrays.asList(SALACIOUS, TITILATING, SWEET, ELITE, FINAL, CHAMPIONSHIP, KING);
    }

    public Team getWinner(Game game) {
        return null;
    }

    public Bracket createMaster(CreateMasterBracketForm form) {
        /* todo better way of finding admin */
        Bracket master = Bracket.builder()
                .user(userRepository.findByUsername("srang"))
                .isMaster(true)
                .name(form.getName())
                .build();
        Map<Integer, Team> teamMap = teamService.getTeams();
        List<Integer> matchups = generateMatchups();
        form.getRankedTeams().forEach((r, teams) -> {
            Region region = Region.RegionType.valueOf(r).region();
            IntStream.range(0, matchups.size()).forEach((index) -> {
                int rank = matchups.get(index);
                // 1 based indexing
                Integer gameIndex = 8 * (r - 1) + index + 1;
                Game game = Game.builder()
                        .gameIndex(gameIndex)
                        .bracket(master)
                        .round(SALACIOUS.id())
                        .teamAlpha(teamMap.get(teams.get(rank)))
                        .teamBravo(teamMap.get(teams.get(regionSize + 1 - rank)))
                        .build();
                master.addGame(game);
            });
        });
        bracketRepository.save(master);
        return master;
    }

    public void saveMaster(BracketForm bracketForm) {
        Bracket master = getMaster();
        updateBracket(bracketForm, master);
    }

    public void updateBracket(BracketForm bracketForm, Bracket bracket) {
        Map<Integer, Map<Integer, GameTouple>> formMap = bracketForm.getGames();
        List<Game> games = bracket.getGames();
//        Map<Integer, Map<Integer, Game>> gameMap = classify(games);
        formMap.forEach((round, roundGames) -> {
            roundGames.forEach((gameIndex, gameTouple) -> {
                // todo figure out better way to handle null safe gets in map
//                Map<Integer, Game> asdf = gameMap.get(round);
//                Game game = (asdf == null) ? null : asdf.get(gameIndex);

                Game game = games.stream()
                        .filter(g -> g.getRound() == round && g.getGameIndex() == gameIndex).findAny()
                        .orElse(Game.builder()
                            .bracket(bracket)
                            .round(round)
                            .gameIndex(gameIndex)
                            .build()
                        );
                gameService.setTeamForGame("A", gameTouple.getTeamA(), game);
                gameService.setTeamForGame("B", gameTouple.getTeamB(), game);
            });
        });
        bracketRepository.save(bracket);
        Bracket comp = bracketRepository.findOne(bracket.getBracketId());
    }

    protected Map classify(List<Game> games) {
        return games.stream().collect(groupingBy(Game::getRound, toMap(Game::getGameIndex, game->game)));
    }

    public void updateBracket(BracketForm bracketForm, Integer bracketId) {
        Bracket bracket = bracketRepository.findOne(bracketId);
    }

    public void createBracket(BracketForm bracketForm) {
        Bracket bracket = new Bracket();
        bracket = bracketRepository.save(bracket);
        this.updateBracket(bracketForm, bracket);
    }
}
