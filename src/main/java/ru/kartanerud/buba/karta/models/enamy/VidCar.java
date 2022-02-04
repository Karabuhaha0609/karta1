package ru.kartanerud.buba.karta.models.enamy;

public enum VidCar {
    ODINOCHKA3("3-х осый"),
    ODINOCHKA4("4-х осый"),
    TONAR("Тонар"),
    POLUPRITCEP("Полуприцеп"),
    MALOTONAZH("Малотоннажка");


    private final String carEnum;

    VidCar(String carEnum) {
        this.carEnum = carEnum;
    }

    public String getCarEnum() {
        return carEnum;
    }
}

