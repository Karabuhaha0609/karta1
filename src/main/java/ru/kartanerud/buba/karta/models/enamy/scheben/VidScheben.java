package ru.kartanerud.buba.karta.models.enamy.scheben;

import javax.transaction.Transactional;

@Transactional
public enum VidScheben {
    IZVESTNYAK("Известняковый"),
    GRAVIY("Гравийный"),
    GRANIT("Гранитный"),
    SHLAK("Шлаковый"),
    VTORICHNIY("Вторичный");

    private final String vidSchebenEnum;

    VidScheben(String vidSchebenEnum) {
        this.vidSchebenEnum = vidSchebenEnum;
    }

    public String getVidSchebenEnum() {
        return vidSchebenEnum;
    }
}
