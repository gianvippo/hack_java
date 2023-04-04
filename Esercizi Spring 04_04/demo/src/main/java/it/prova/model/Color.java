package it.prova.model;

public enum Color {
    BN("B/N"),
    COLOR("Colore");

    private String value;

    private Color(String value) {
        this.value = value;
    }

    public String toString() {
        return this.value; // will return , or ' instead of COMMA or APOSTROPHE
    }
}
