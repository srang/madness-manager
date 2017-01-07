package org.srang.madness.manager.model.forms;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by srang on 12/17/16.
 */
@Getter
@Setter
public class CreateMasterBracketForm {
    Map<String, List<String>> rankedTeams;
    public CreateMasterBracketForm() {
        rankedTeams = new RegionMap();
    }
    private class RegionMap extends HashMap<String, List<String>> {
        @Override
        public List<String> get(Object key) {
            List<String> vals = super.get(key);
            if (vals == null) {
                vals = new ArrayList<>();
                this.put((String) key, vals);
            }
            return vals;
        }
    }
}
