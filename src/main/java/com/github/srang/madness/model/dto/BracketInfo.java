package com.github.srang.madness.model.dto;

import com.github.srang.madness.model.entities.Team;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by srang on 1/10/17.
 */
@Data
@NoArgsConstructor
public class BracketInfo {
    String name;
    String bracketId;
    String ownerName;
    Team winner;

    @Builder
    @java.beans.ConstructorProperties({"name", "bracketId", "ownerName", "winner"})
    public BracketInfo(String name, String bracketId, String ownerName, Team winner) {
        this.name = name;
        this.bracketId = bracketId;
        this.ownerName = ownerName;
        this.winner = winner;
    }
}
