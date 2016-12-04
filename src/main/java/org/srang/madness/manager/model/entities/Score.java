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
@Table(name = "scores")
public class Score implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "score_id", unique = true, nullable = false)
    Integer scoreId;
    @ManyToOne
    @JoinColumn(name = "ruleset_id", nullable = false)
    Ruleset ruleset;
    @ManyToOne
    @JoinColumn(name = "bracket_id", nullable = false)
    Bracket bracket;
    @Column(name = "score", nullable = false)
    Integer score;

    @Builder
    public Score(Ruleset ruleset, Bracket bracket, Integer score) {
        this.ruleset = ruleset;
        this.bracket = bracket;
        this.score = score;
    }
}
