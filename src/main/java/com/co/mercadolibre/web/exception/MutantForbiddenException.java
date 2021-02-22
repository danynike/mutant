/**
 * 
 */
package com.co.mercadolibre.web.exception;

/**
 * @author DANIEL MORENO AREVALO
 *
 */
@SuppressWarnings("serial")
public class MutantForbiddenException  extends RuntimeException {

    public MutantForbiddenException() {
        super();
    }

    public MutantForbiddenException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public MutantForbiddenException(final String message) {
        super(message);
    }

    public MutantForbiddenException(final Throwable cause) {
        super(cause);
    }
}