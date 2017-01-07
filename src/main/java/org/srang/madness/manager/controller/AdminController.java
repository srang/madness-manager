package org.srang.madness.manager.controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.srang.madness.manager.model.entities.Bracket;
import org.srang.madness.manager.model.entities.Region;
import org.srang.madness.manager.model.forms.CreateMasterBracketForm;
import org.srang.madness.manager.service.BracketService;
import org.srang.madness.manager.service.TeamService;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.srang.madness.manager.model.entities.Region.RegionType.*;

/**
 * Created by samuelrang on 11/5/2016.
 */
@Controller
@RequestMapping("/app/admin")
@Secured("ROLE_ADMIN")
@Log
public class AdminController {
    @Autowired
    BracketService bracketService;
    @Autowired
    TeamService teamService;

    @RequestMapping("")
    public String index(Model model) {
        return "admin/index";
    }

    @GetMapping("/brackets/master")
    public String showMaster(Model model) {
        Bracket master = bracketService.repository().findMasterBracket();
        if (master == null) {
            List<Region> regions = Arrays.asList(EAST,WEST,SOUTH,MIDWEST).stream()
                    .map(Region.RegionType::region).collect(toList());
            model.addAttribute("bracketForm", new CreateMasterBracketForm(regions, teamService));
            model.addAttribute("teams", teamService.getTeams());
            model.addAttribute("regions", regions);
            model.addAttribute("matchups", bracketService.generateMatchups());

            return "bracket/create_master";
            /*
            //need to set up master bracket
            $teams = Team::where('name','<>','TBD')->select('name','team_id')->get();
            $regions = Region::orderedRegions();
            $game_nums = BracketFactory::generateMatchups();
            JavaScript::put([
                    'teams' => $teams,
            ]);
            return view('admin.create_master',[
                    'matchups' => $game_nums,
            'teamRepo' => $this->teamRepo,
                    'teams' => $teams,
                    'regions' => $regions,
                    'region_size' => 16,
            ]);
            */
        }
        /*
        $games = BracketFactory::reverseBracket($bracket,new ReverseBaseBracketStrategy());
        $regions = Region::orderedRegions();
        $rounds = count($games);
        return view('brackets.bracket_display',[
            'teamRepo' => $this->teamRepo,
            'bracket' => $bracket,
            'master' => true,
            'games' => $games,
            'regions' => $regions,
            'game_container' => 'brackets.game_buttons',
            'bracket_link' => url('admin/brackets/master'),
            'back_link' => url('admin/brackets')
        ]);
         */
        return "home";
    }

    @PostMapping("/brackets/master/create")
    public String createMaster(CreateMasterBracketForm bracketForm) {
        String blah = bracketForm.toString();
        return "redirect:/app/admin/brackets/master";
    }

    @PostMapping("/brackets/master")
    public String updateMaster(Model model) {

        return "redirect:/app/admin/brackets/master";
    }
}
