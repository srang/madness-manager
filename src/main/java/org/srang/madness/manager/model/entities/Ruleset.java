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
@Table(name = "rulesets")
public class Ruleset implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "ruleset_id", unique = true, nullable = false)
    Integer rulesetId;
    @Column(name = "name", nullable = false)
    String name;
    @Column(name = "desc", nullable = false)
    String description;

    @Builder
    public Ruleset(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
