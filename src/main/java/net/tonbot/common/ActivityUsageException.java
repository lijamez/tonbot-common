package net.tonbot.common;

/**
 * An exception which indicates that the user entered an input incorrectly.
 */
@SuppressWarnings("serial")
public class ActivityUsageException extends TonbotException {

	public ActivityUsageException(String message) {
		super(message);
	}

	public ActivityUsageException(String message, Exception e) {
		super(message, e);
	}

}
