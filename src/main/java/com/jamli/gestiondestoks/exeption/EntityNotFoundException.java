package com.jamli.gestiondestoks.exeption;

import lombok.Getter;

public class EntityNotFoundException extends RuntimeException{
    @Getter
    private ErrorCodes errorCode;
    //des constructeurs pour l'envoie de msg d'erreur

    public EntityNotFoundException(String message){
        super(message);
    }
    public EntityNotFoundException(String message, Throwable cause) {

        super(message, cause);
    }

    public EntityNotFoundException(String message, Throwable cause, ErrorCodes errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public EntityNotFoundException(String message, ErrorCodes errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

}