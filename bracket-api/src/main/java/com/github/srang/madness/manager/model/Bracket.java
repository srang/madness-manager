package com.github.srang.madness.manager.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Bracket extends PanacheEntity {
    public static Bracket findByName(String name) {
        return find("name", name).firstResult();
    }


    @Column
    public String name;

    @ManyToOne
    @JoinColumn(name = "bracket_root")
    public Game rootGame;

    @ManyToOne
    @JoinColumn(name = "master_bracket")
    public Bracket master;
}
