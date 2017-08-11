package com.tonberry.tonbot.common;

/**
 * A generic Tonbot exception.
 */
public abstract class TonbotException extends RuntimeException {

    public TonbotException(String message, Exception causedBy) {
        super(message, causedBy);
    }

    public TonbotException(String message) {
        super(message);
    }
}
