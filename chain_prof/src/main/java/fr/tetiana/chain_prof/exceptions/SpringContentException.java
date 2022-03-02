package fr.tetiana.chain_prof.exceptions;

public class SpringContentException extends RuntimeException {
    public SpringContentException(String exMessage, Exception exception) {
        super(exMessage, exception);
    }

    public SpringContentException(String exMessage) {
        super(exMessage);
    }
}
