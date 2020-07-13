package org.exite.servertest.exception;

public class InternalDBException extends Exception{
    public InternalDBException(String message) {
        super(message);
    }
    public InternalDBException(String message, Throwable cause) {
        super(message, cause);
    }
}
