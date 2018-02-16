package net.tonbot.common;

import org.apache.commons.lang3.NotImplementedException;

public interface Activity {

	/**
	 * Gets the {@link ActivityDescriptor}.
	 * 
	 * @return {@link ActivityDescriptor}. Non-null.
	 */
	public ActivityDescriptor getDescriptor();

	/**
	 * Gets the request type. This method must be implemented if the @Enactable
	 * method is a generic type. Otherwise, the message event dispatcher cannot
	 * determine the request class to map to.
	 * 
	 * @return The request type. Non-null.
	 */
	public default Class<?> getRequestType() {
		throw new NotImplementedException("getRequestType is not implemented.");
	}
}
