package org.srang.madness.manager.service;

import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.srang.madness.manager.model.forms.CreateMasterBracketForm;
import org.srang.madness.manager.model.repositories.BracketRepository;
import org.srang.madness.manager.model.types.Region;
import org.srang.madness.manager.model.types.Round;

import java.util.Arrays;
import java.util.List;

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
}
