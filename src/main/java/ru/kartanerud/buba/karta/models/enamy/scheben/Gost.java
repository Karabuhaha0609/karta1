package ru.kartanerud.buba.karta.models.enamy.scheben;

public enum Gost {

    GOST826793("ГОСТ 8267-93"),
    GOSTNULL(""),
    GOST314242010("ГОСТ 31424-2010"),
    GOSTR547482011("ГОСТ Р 54748-2011"),
    GOST324952013("ГОСТ 32495-2013"),
    GOST334483("ГОСТ 3344-83"),
    GOST2285689("ГОСТ 22856-89"),
    GOST2226376("ГОСТ 22263-76"),
    GOST2664485("ГОСТ 26644-85"),
    GOST557894("ГОСТ 5578-94"),
    GOST2522696("ГОСТ 25226-96"),
    GOST1886693("ГОСТ 18866-93"),
    GOST108322009("ГОСТ 10832-2009");

    private final String gostEnum;

    Gost(String gostEnum) {
        this.gostEnum = gostEnum;
    }

    public String getGostEnum() {
        return gostEnum;
    }
}
