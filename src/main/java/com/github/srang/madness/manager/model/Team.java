package com.github.srang.madness.manager.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class Team {
    @NotBlank
    private String name;
    @NotBlank
    @Pattern(regexp = "[A-Fa-f0-9]{3,6}")
    private String primaryColor;
    @Pattern(regexp = "[A-Fa-f0-9]{3,6}")
    private String secondaryColor;

    public Team(String name, String primaryColor, String secondaryColor) {
        this.name = name;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
    }

    public Team() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(String primaryColor) {
        this.primaryColor = primaryColor;
    }

    public String getSecondaryColor() {
        return secondaryColor;
    }

    public void setSecondaryColor(String secondaryColor) {
        this.secondaryColor = secondaryColor;
    }
}
