package ru.kartanerud.buba.karta.exception;

import java.text.MessageFormat;

public class SchebenIsAlreadyAssignedException extends RuntimeException{
    public SchebenIsAlreadyAssignedException(final Long schebenId, final Long karierId){
        super(MessageFormat.format("Scheben:{0} is already assigned to karier {1}", schebenId, karierId));
    }
}
