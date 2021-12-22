package ru.kartanerud.buba.karta.exception;

import java.text.MessageFormat;

public class SchebenNotFoundException extends RuntimeException{

    public SchebenNotFoundException(final Long id){
        super(MessageFormat.format("Щебень с таким id не найден: {0}", id));
    }
}
