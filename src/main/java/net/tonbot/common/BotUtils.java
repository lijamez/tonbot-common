package net.tonbot.common;

import sx.blah.discord.api.internal.json.objects.EmbedObject;
import sx.blah.discord.handle.obj.IChannel;

/**
 * A helper class to send data to discord. Thread safe.
 */
public interface BotUtils {

	/**
	 * Asynchronously sends a message. Will retry if a RateLimitException is
	 * returned by Discord.
	 * 
	 * @param channel
	 *            The channel to send the message to. Non-null.
	 * @param message
	 *            The message to be sent. Must be non-null, non-empty.
	 */
	void sendMessage(IChannel channel, String message);

	/**
	 * Asynchronously sends an embed object. Will retry if RateLimitException is
	 * returned by Discord.
	 * 
	 * @param channel
	 *            The channel to send the message to. Non-null.
	 * @param embedObj
	 *            The embed object. Non-null.
	 */
	void sendEmbed(IChannel channel, EmbedObject embedObj);
}
