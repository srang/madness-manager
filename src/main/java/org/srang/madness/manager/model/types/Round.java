package org.srang.madness.manager.model.types;

/**
 * Created by srang on 1/10/17.
 */
public enum Round {
    SALACIOUS(0, "First Round", 64, 32),
    TITILATING(1, "Second Round", 32, 16),
    SWEET(2, "Sweet Sixteen", 16, 8),
    ELITE(3, "Elite Eight", 8, 4),
    FINAL(4, "Final Four", 4, 2),
    CHAMPIONSHIP(5, "National Championship", 2, 1),
    KING(6, "National Champion", 1, 1);

    private int id;
    private String label;
    private Integer teams;
    private Integer games;


    private Round(int id, String label, Integer teams, Integer games) {
        this.id = id;
        this.label = label;
        this.teams = teams;
        this.games = games;
    }

    public static Round valueOf(Integer id) { return Round.values()[id]; }

    public Integer id() {
        return Integer.valueOf(id);
    }

    public String label() {
        return this.label;
    }

    public Integer teams() {
        return this.teams;
    }

    public Integer games() {
        return this.games;
    }

}

