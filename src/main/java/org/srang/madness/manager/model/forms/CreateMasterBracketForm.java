package org.srang.madness.manager.model.forms;

import lombok.Getter;
import lombok.Setter;
import org.srang.madness.manager.model.entities.Region;
import org.srang.madness.manager.model.validation.AllTeamsFilled;
import org.srang.madness.manager.model.validation.TeamsExactlyOnce;
import org.srang.madness.manager.service.TeamService;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by srang on 12/17/16.
 */
@Getter
@Setter
@AllTeamsFilled
@TeamsExactlyOnce
public class CreateMasterBracketForm {
    /**
     * maps <RegionId <TeamRank, TeamId>>
     */
    Map<Integer, Map<Integer, Integer>> rankedTeams;
    @NotNull
    String name;
    @NotNull
    Boolean madnessFlag;
    public CreateMasterBracketForm(List<Region> regions, final TeamService teamService) {
        rankedTeams = new RegionMap(regions, teamService);
        name = "Master Bracket";
        madnessFlag = false;
    }
    public CreateMasterBracketForm() {
    }
    private class RegionMap extends HashMap<Integer, Map<Integer, Integer>> {
        public RegionMap(List<Region> regions, TeamService teamService) {
            for(Region region : regions) {
                this.put(region.getRegionId(), teamService.getRankedRegionTeams(region));
            }
        }

    }
}
