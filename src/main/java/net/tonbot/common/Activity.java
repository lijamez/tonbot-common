package net.tonbot.common;

import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

public interface Activity {

	/**
	 * Gets the {@link ActivityDescriptor}.
	 * 
	 * @return {@link ActivityDescriptor}. Non-null.
	 */
	public ActivityDescriptor getDescriptor();

	/**
	 * Runs the activity.
	 * 
	 * @param event
	 *            The {@link MessageReceivedEvent}. Non-null.
	 * @param args
	 *            The arguments. Non-null.
	 * @throws TonbotBusinessException
	 *             If a user error occurred.
	 */
	public default void enact(MessageReceivedEvent event, String args) {
		
	}
}
