package ru.kartanerud.buba.karta.exception;

import java.text.MessageFormat;

public class KarierNotFoundException extends RuntimeException{

    public KarierNotFoundException(final Long id){
        super(MessageFormat.format("Карьер с таким id не найден: {0}", id));
    }
}
