package org.srang.madness.manager.model.entities;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by srang on 11/5/2016.
 */
@Data
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "games")
public class Game implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "game_id", unique = true, nullable = false)
    Integer gameId;
    @JoinColumn(name = "team_a", nullable = false)
    Team teamAlpha;
    @JoinColumn(name = "team_b", nullable = false)
    Team teamBravo;
    @Column(name = "score_a")
    Integer scoreAlpha;
    @Column(name = "score_b")
    Integer scoreBravo;
    @Column(name = "master", nullable = false)
    Boolean isMaster;
    @JoinColumn(name = "winner")
    Team winner;
    @Column(name = "round_id", nullable = false)
    Integer round;
    @JoinColumn(name = "child_game_a")
    Game childGameAlpha;
    @JoinColumn(name = "child_game_a")
    Game childGameBravo;

    @Builder
    public Game(Team teamAlpha, Team teamBravo, Integer scoreAlpha, Integer scoreBravo, Boolean isMaster, Team winner, Integer round, Game childGameAlpha, Game childGameBravo) {
        this.teamAlpha = teamAlpha;
        this.teamBravo = teamBravo;
        this.scoreAlpha = scoreAlpha;
        this.scoreBravo = scoreBravo;
        this.isMaster = isMaster;
        this.winner = winner;
        this.round = round;
        this.childGameAlpha = childGameAlpha;
        this.childGameBravo = childGameBravo;
    }
}
