package ru.kartanerud.buba.karta.models.enamy.scheben;

public enum MarkaProchnosti {

    M200("M200"),
    M400("M400"),
    M600("M600"),
    M800("M800"),
    M1000("M1000"),
    M1200("M1200"),
    M1400("M1400");

    private final String markaProchnostiEnum;

    MarkaProchnosti(String markaProchnostiEnum) {
        this.markaProchnostiEnum = markaProchnostiEnum;
    }

    public String getMarkaProchnostiEnum() {
        return markaProchnostiEnum;
    }
}
