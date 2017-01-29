package com.github.srang.madness.model.types;

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
@Table(name = "states")
public class State implements Serializable {
    /* TODO define enum */

    @Id
    @GeneratedValue
    @Column(name = "state_id", unique = true, nullable = false)
    Integer stateId;
    @Column(name = "name")
    String name;
    @ManyToOne
    @JoinColumn(name = "next_id")
    State nextId;
    @ManyToOne
    @JoinColumn(name = "prev_id")
    State prevId;

    @Override
    public String toString() {
        return "State{" +
                "name=" + name +
                ", next=" + nextId.getStateId() +
                ", prev=" + prevId.getStateId() +
                ", stateId=" + stateId +
                '}';
    }
}
