package com.co.mercadolibre.web.exception;

@SuppressWarnings("serial")
public class MutantMismatchException extends RuntimeException {

    public MutantMismatchException() {
        super();
    }

    public MutantMismatchException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public MutantMismatchException(final String message) {
        super(message);
    }

    public MutantMismatchException(final Throwable cause) {
        super(cause);
    }
}
