package com.github.srang.madness.manager.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Game extends PanacheEntity{

    public static List<Game> findRootGames() {
        return find("select g from Game g where g.parent is null").list();
    }

    @Column
    public Integer round;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "left_team")
    public Team teamLeft;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "right_team")
    public Team teamRight;

    @Column
    public Integer scoreLeft;

    @Column
    public Integer scoreRight;

    @JsonbTransient
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="parent")
    public Game parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    public List<Game> children;

}
