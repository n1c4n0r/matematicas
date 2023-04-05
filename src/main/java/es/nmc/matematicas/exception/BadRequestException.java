package es.nmc.matematicas.exception;


public class BadRequestException extends RuntimeException {
    public BadRequestException(String msg){
        super(msg);
    }

}