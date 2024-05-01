package com.cadastrorh.cadastroRHapi.exception;

public class InvalidEmailFormatException  extends RuntimeException {
    public InvalidEmailFormatException(String message) {
        super(message);
    }
}
