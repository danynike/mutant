package com.co.mercadolibre.web.exception;

@SuppressWarnings("serial")
public class MutantNotFoundException extends RuntimeException {

    public MutantNotFoundException() {
        super();
    }

    public MutantNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public MutantNotFoundException(final String message) {
        super(message);
    }

    public MutantNotFoundException(final Throwable cause) {
        super(cause);
    }
}