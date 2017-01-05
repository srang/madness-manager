package org.srang.madness.manager.model.forms;

import lombok.Getter;
import lombok.Setter;

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
        rankedTeams = new HashMap<>();
    }
}
