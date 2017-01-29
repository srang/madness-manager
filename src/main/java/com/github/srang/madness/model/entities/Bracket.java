package com.github.srang.madness.model.entities;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by srang on 11/5/2016.
 */
@Data
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "brackets")
public class Bracket implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "bracket_id", unique = true, nullable = false)
    Integer bracketId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
    @OneToMany(mappedBy = "bracket", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Game> games;
    @Column(name = "name", nullable = false)
    String name;
    @Column(name = "master", nullable = false)
    Boolean isMaster;

    @Builder
    public Bracket(User user, @Singular List<Game> games, String name, Boolean isMaster) {
        this.user = user;
        this.name = name;
        this.games = new ArrayList<>(games);
        this.isMaster = isMaster;
    }

    public final Bracket addGame(Game game) {
        this.games.add(game);
        return this;
    }

    @Override
    public String toString() {
        return "Bracket{" +
                "user=" + user +
                ", games=" + games +
                ", name='" + name + '\'' +
                ", isMaster=" + isMaster +
                '}';
    }
}
