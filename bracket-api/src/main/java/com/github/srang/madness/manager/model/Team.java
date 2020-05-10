package com.github.srang.madness.manager.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class Team extends PanacheEntity {

    public static Team findByName(String name) {
        return find("name", name).firstResult();
    }

    public static Team generateTeam(Team incoming) {
        Team team = new Team();
        team.name = incoming.name;
        team.primaryColor = incoming.primaryColor;
        team.secondaryColor = incoming.secondaryColor;
        return team;
    }

    public static Team mirrorFields(Team toMirror, Team mirroring) {
        toMirror.name = mirroring.name;
        toMirror.primaryColor = mirroring.primaryColor;
        toMirror.secondaryColor = mirroring.secondaryColor;
        return toMirror;
    }

    @Column(unique = true)
    @NotBlank
    public String name;

    @Column
    @NotBlank
    @Pattern(regexp = "([A-Fa-f0-9]{3}){1,2}")
    public String primaryColor;

    @Column
    @Pattern(regexp = "([A-Fa-f0-9]{3}){1,2}")
    public String secondaryColor;

    @Override
    public String toString() {
        return "Team{" +
            "name='" + name + '\'' +
            ", primaryColor='" + primaryColor + '\'' +
            ", secondaryColor='" + secondaryColor + '\'' +
            ", id=" + id +
            '}';
    }
}
