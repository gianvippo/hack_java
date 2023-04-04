package it.prova.model;

public enum Ratio {
    SIXTEEN_NINTHS("16:9"),
    ONE_EIGHTYFIVE("1.85:1"),
    TWO_THIRTYNINE("2.39:1"),
    FOUR_THIRDS("4:3");

    private String value;

    private Ratio(String value) {
        this.value = value;
    }

    public String toString() {
        return this.value;
    }
}
