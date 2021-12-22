package ru.kartanerud.buba.karta.models.enamy.karier;

public enum Oblast {
    MOSCOW ("Московкая обл."),
    KALUGA("Калужкая обл."),
    SMOLENSK("Смоленская обл."),
    VLADIMIROBL("Владимирская обл."),
    TULAOBL("Тульская обл.");

    private final String displayName;

    Oblast(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
