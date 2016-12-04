package org.srang.madness.manager.model.entities;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * Created by srang on 11/5/2016.
 */
@Data
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "tournaments")
public class Tournament {
    @Id
    @GeneratedValue
    @Column(name = "tournament_id", unique = true, nullable = false)
    Integer tournamentId;
    @Column(name = "name", nullable = false)
    String name;
    @ManyToOne
    @JoinColumn(name = "state_id", nullable = false)
    State state;
    @Column(name = "active", nullable = false)
    Boolean active;

    @Builder
    public Tournament(String name, State state, Boolean active) {
        this.name = name;
        this.state = state;
        this.active = active;
    }
}
