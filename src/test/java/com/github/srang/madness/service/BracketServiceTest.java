package com.github.srang.madness.service;

import com.github.srang.madness.model.entities.Game;
import com.github.srang.madness.model.forms.CreateMasterBracketForm;
import com.github.srang.madness.model.repositories.BracketRepository;
import com.github.srang.madness.model.types.Region;
import com.github.srang.madness.model.types.Round;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Created by srang on 1/8/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Log
public class BracketServiceTest {

    @Mock
    BracketRepository bracketRepository;

    @InjectMocks
    BracketService bracketService;

    @Test
    public void testGameIds() throws Exception {
        List<Integer> ids = bracketService.getRoundRegionGameIds(Round.SALACIOUS, Region.RegionType.REGION_A);
        assertThat(ids, is(Arrays.asList(1,2,3,4,5,6,7,8)));
        ids = bracketService.getRoundRegionGameIds(Round.SWEET, Region.RegionType.REGION_B);
        assertThat(ids, is(Arrays.asList(3,4)));
    }

    @Test
    public void testRegions() throws Exception {
        List<Region> regions = bracketService.regions();
        assertThat(regions.size(), is(4));
        assertThat(regions, not(contains(Region.RegionType.UNSPECIFIED)));
    }

    @Test
    public void testCreateMaster() throws Exception {
        CreateMasterBracketForm form = new CreateMasterBracketForm();
        // TODO
        assertThat(true, is(true));
    }

    @Test
    public void testGameListReduce() throws Exception {
        List<Game> gameList = new ArrayList<>();
        IntStream.range(0,7).forEach(i -> {
            IntStream.range(1, 16/(i+1)+1).forEach(i1 -> {
                Game g = new Game();
                g.setRound(i);
                g.setGameIndex(i1);
                gameList.add(g);
            });
        });
        Map<Integer, Map<Integer, Game>> gameMap = bracketService.classify(gameList);
        assertThat(gameMap, not(nullValue()));
        assertThat(gameMap.values().stream().flatMap(map -> map.values().stream()).collect(toList()).size(), equalTo(40));
    }
}
