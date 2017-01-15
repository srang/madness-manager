package org.srang.madness.manager.model.entities;

import org.junit.Test;
import org.srang.madness.manager.model.types.Region;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by srang on 1/8/17.
 */
public class RegionTest {

    @Test
    public void testRegionFromType() throws Exception {
        Region r = Region.RegionType.REGION_A.region();
        assertThat(r.getName(), is(Region.RegionType.REGION_A.value()));
        assertThat(r.getRegionId(), is(Region.RegionType.REGION_A.getId()));
    }

    @Test
    public void testRegionTypeFromInt() throws Exception {
        Region r = Region.RegionType.valueOf(Integer.valueOf(1)).region();
        assertThat(r, is(Region.RegionType.REGION_A.region()));
    }

    @Test
    public void testRegionTypeFromString() throws Exception {
        Region r = Region.RegionType.valueOf("REGION_A").region();
        assertThat(r, is(Region.RegionType.REGION_A.region()));
    }
}
