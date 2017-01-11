package org.srang.madness.manager.model.types;

/**
 * Created by srang on 1/10/17.
 */
public enum Round {
    SALACIOUS(0, "First Round"),
    TITILATING(1, "Second Round"),
    SWEET(2, "Sweet Sixteen"),
    ELITE(3, "Elite Eight"),
    FINAL(4, "Final Four"),
    CHAMPIONSHIP(5, "National Championship"),
    KING(6, "National Champion");

    private int id;
    private String value;

    private Round(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public Integer id() {
        return Integer.valueOf(id);
    }

    public String value() {
        return this.value;
    }
}

