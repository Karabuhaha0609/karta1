package ru.kartanerud.buba.karta.models.enamy.scheben;

public enum Radioaktivnost {

    NULL(""),
    IKLASS("I класс (до 370 Бк/кг)"),
    IIKLASS("II класс (до 740 Бк/кг)"),
    IIIKLASS("III класс(до 1,5 кБк/кг)"),
    IVKLASS("IV класс (до 4,0 кБк/кг)");

    private final String radioaktivnostEnum;

    Radioaktivnost(String radioaktivnostEnum) {
        this.radioaktivnostEnum = radioaktivnostEnum;
    }

    public String getRadioaktivnostEnum() {
        return radioaktivnostEnum;
    }
}
