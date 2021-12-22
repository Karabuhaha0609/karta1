package ru.kartanerud.buba.karta.models.enamy.scheben;

public enum Morozostoikost {

    FNULL(""),
    F15("F15"),
    F50("F50"),
    F100("F100"),
    F150("F150"),
    F200("F200"),
    F300("F300"),
    F400("F400");

    private final String morozostoikostEnum;

    Morozostoikost(String morozostoikostEnum) {
        this.morozostoikostEnum = morozostoikostEnum;
    }

    public String getMorozostoikostEnum() {
        return morozostoikostEnum;
    }
}
