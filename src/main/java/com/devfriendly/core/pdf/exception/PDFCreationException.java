package com.devfriendly.core.pdf.exception;

/**
 * Created by Patrick Fey on 18.05.2017.
 */
public class PDFCreationException extends Exception{

    public PDFCreationException() {
    }

    public PDFCreationException(String message) {
        super(message);
    }

    public PDFCreationException(String message, Throwable cause) {
        super(message, cause);
    }

    public PDFCreationException(Throwable cause) {
        super(cause);
    }

    public PDFCreationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
