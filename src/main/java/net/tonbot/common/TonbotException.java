package net.tonbot.common;

/**
 * A generic Tonbot exception.
 */
@SuppressWarnings("serial")
public abstract class TonbotException extends RuntimeException {

	public TonbotException(String message, Throwable causedBy) {
		super(message, causedBy);
	}

	public TonbotException(String message) {
		super(message);
	}
}
