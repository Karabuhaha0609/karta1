package ru.kartanerud.buba.karta.models.enamy;

public enum DenNochSmena {
    DEN("день"),
    NOCH("ночь");


    private final String denNochSmenaEnum;

    DenNochSmena(String denNochSmenaEnum) {
        this.denNochSmenaEnum = denNochSmenaEnum;
    }

    public String getdenNochSmenaEnum() {
        return denNochSmenaEnum;
    }
}

