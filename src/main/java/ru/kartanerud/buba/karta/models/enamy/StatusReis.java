package ru.kartanerud.buba.karta.models.enamy;

import javax.transaction.Transactional;

@Transactional
public enum StatusReis {
    NULLREIS("Не принят в работу"),
    TOKARIER("Едет на карьер"),
    TOOBJECT("Едет на объект"),
    ISPOLNEN("Выполнен");

    private final String statusReisEnum;

    StatusReis(String statusReisEnum) {
        this.statusReisEnum = statusReisEnum;
    }

    public String getStatusReisEnum() {
        return statusReisEnum;
    }
}
