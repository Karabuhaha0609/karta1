package ru.kartanerud.buba.karta.models.enamy.scheben;

public enum Leshadnost {

    GROUPNULL(""),
    IGROUP("I группа (до 10%)"),
    IIGROUP("II группа (10-15%)"),
    IIIGROUP("III группа(15-25%)"),
    IVGROUP("IV группа (25-35%)"),
    VIGROUP("V группа (35-50%)");

    private final String leshadnostEnum;

    Leshadnost(String leshadnostEnum) {
        this.leshadnostEnum = leshadnostEnum;
    }

    public String getLeshadnostEnum() {
        return leshadnostEnum;
    }
}
