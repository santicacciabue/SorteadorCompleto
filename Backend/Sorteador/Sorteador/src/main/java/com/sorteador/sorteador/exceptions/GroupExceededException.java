package com.sorteador.sorteador.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;

public class GroupExceededException extends Exception {

    public GroupExceededException(String message) {
        super(message);
    }
}
