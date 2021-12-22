package ru.kartanerud.buba.karta.models.enamy.scheben;

import javax.transaction.Transactional;

@Transactional
public enum Frakcia {
    F520("5-20"),
    F2040("20-40"),
    F4070("40-70"),
    F05("Отсев фр.0-5"),
    F510("Отсев фр.5-10"),
    F515("5-15"),
    F2080("20-80"),
    F80120("80-120"),
    F2560("25-60");

    private final String frakciaEnum;

    Frakcia(String frakciaEnum) {
        this.frakciaEnum = frakciaEnum;
    }

    public String getFrakciaEnum() {
        return frakciaEnum;
    }
}
