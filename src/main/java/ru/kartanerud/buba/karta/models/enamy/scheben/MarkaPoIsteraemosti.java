package ru.kartanerud.buba.karta.models.enamy.scheben;

public enum MarkaPoIsteraemosti {

    INULL(""),
    I1("И1"),
    I2("И2"),
    I3("И3"),
    I4("И4");

   private final String markaPoIsteraemostiEnum;

    MarkaPoIsteraemosti(String markaPoIsteraemostiEnum) {
        this.markaPoIsteraemostiEnum = markaPoIsteraemostiEnum;
    }

    public String getMarkaPoIsteraemostiEnum() {
        return markaPoIsteraemostiEnum;
    }
}
