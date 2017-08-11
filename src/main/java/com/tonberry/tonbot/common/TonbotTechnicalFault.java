package com.tonberry.tonbot.common;

/**
 * A technical fault is indicative of internal errors. Exceptions of this type should not be surfaced to users.
 */
public class TonbotTechnicalFault extends TonbotException {

    public TonbotTechnicalFault(String message, Exception e) {
        super(message, e);
    }

    public TonbotTechnicalFault(String message) {
        super(message);
    }
}
