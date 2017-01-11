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
    @ManyToOne
    @JoinColumn(name = "team_a", nullable = false)
    Team teamAlpha;
    @ManyToOne
    @JoinColumn(name = "team_b", nullable = false)
    Team teamBravo;
    @Column(name = "score_a")
    Integer scoreAlpha;
    @Column(name = "score_b")
    Integer scoreBravo;
    @Column(name = "round_id", nullable = false)
    Integer round;
    @Column(name = "game_index", nullable = false)
    Integer gameIndex;
    @ManyToOne
    @JoinColumn(name = "bracket_id", referencedColumnName = "bracket_id", nullable = false)
    Bracket bracket;

    @Builder
    public Game(Team teamAlpha, Team teamBravo, Integer scoreAlpha, Integer scoreBravo, Integer round, Integer gameIndex, Bracket bracket) {
        this.teamAlpha = teamAlpha;
        this.teamBravo = teamBravo;
        this.scoreAlpha = scoreAlpha;
        this.scoreBravo = scoreBravo;
        this.round = round;
        this.gameIndex = gameIndex;
        this.bracket = bracket;
    }
}
