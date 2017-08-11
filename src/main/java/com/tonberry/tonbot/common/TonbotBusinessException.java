package com.tonberry.tonbot.common;

/**
 * A business exception indicates an error that is caused by the user.
 * Exceptions of this type should be surfaced to users.
 */
public abstract class TonbotBusinessException extends TonbotException {

    public TonbotBusinessException(String message, Exception e) {
        super(message, e);
    }

    public TonbotBusinessException(String message) {
        super(message);
    }
}
