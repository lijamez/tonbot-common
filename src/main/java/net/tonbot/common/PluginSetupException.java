package net.tonbot.common;

import com.google.common.base.Preconditions;

/**
 * An exception which indicates that a plugin was not set up correctly or at
 * all.
 */
@SuppressWarnings("serial")
public class PluginSetupException extends RuntimeException {

	/**
	 * Constructor.
	 * 
	 * @param message
	 *            A helpful user-facing message about what the problem is and what
	 *            they need to do to resolve it. Non-null.
	 */
	public PluginSetupException(String message) {
		this(message, null);
	}

	/**
	 * Constructor.
	 * 
	 * @param message
	 *            A helpful user-facing message about what the problem is and what
	 *            they need to do to resolve it. Non-null.
	 * @param causedBy
	 *            the CausedBy exception. Nullable.
	 */
	public PluginSetupException(String message, Exception causedBy) {
		super(message, causedBy);

		Preconditions.checkNotNull(message, "message must be non-null.");
	}
}
