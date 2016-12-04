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
@Table(name = "rules")
public class Rule implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "rule_id", unique = true, nullable = false)
    Integer ruleId;
    @ManyToOne
    @JoinColumn(name = "ruleset_id", nullable = false)
    Ruleset ruleset;
    @Column(name = "round_id", nullable = false)
    Integer roundId;
    @Column(name = "rule", nullable = false)
    String value;

    @Builder
    public Rule(Ruleset ruleset, Integer roundId, String value) {
        this.ruleset = ruleset;
        this.roundId = roundId;
        this.value = value;
    }
}
