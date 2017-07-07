package com.aegon.exception;

import java.util.ArrayList;
import java.util.List;

public class RemoteServiceException extends Exception {
    private final List<String> errors;

    public RemoteServiceException(final String message, final List<String> errors) {
        this(message, errors, null);
    }

    /**
     * Creates an error report.
     *
     * @param message error message
     */
    public RemoteServiceException(final String message, final Throwable throwable) {
        this(message, null, throwable);
    }

    /**
     * Creates an error report.
     *
     * @param message error message
     * @param errors {@code Set} of {@link String}
     * @param cause the cause of the exception
     */
    public RemoteServiceException(final String message, final List<String> errors, final Throwable cause) {
        super(message, cause);

        if (errors == null) {
            this.errors = new ArrayList<String>();
        } else {
            this.errors = errors;
        }
    }

    /**
     * Set of errors reported.
     *
     * @return {@code List} of {@link String}
     */
    public List<String> getErrors() {
        return errors;
    }
}
