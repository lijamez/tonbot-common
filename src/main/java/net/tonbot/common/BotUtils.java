package net.tonbot.common;

import java.io.InputStream;

import sx.blah.discord.api.internal.json.objects.EmbedObject;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IMessage;

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
	 * Synchronously sends a message. Will retry if a RateLimitException is returned
	 * by Discord.
	 * 
	 * @param channel
	 *            The channel to send the message to. Non-null.
	 * @param message
	 *            The message to be sent. Must be non-null, non-empty.
	 * @return The {@link IMessage}.
	 * @throws TonbotTechnicalFault
	 *             if the message could not be sent.
	 */
	IMessage sendMessageSync(IChannel channel, String message);

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
	
	/**
	 * Synchronously sends an embed object. Will retry if RateLimitException is
	 * returned by Discord.
	 * 
	 * @param channel
	 *            The channel to send the message to. Non-null.
	 * @param embedObj
	 *            The embed object. Non-null.
	 * @return The sent embed message.
	 */
	IMessage sendEmbedSync(IChannel channel, EmbedObject embedObj);

	/**
	 * Asynchronously sends an embed object with an image. Will retry if
	 * RateLimitException is returned by Discord.
	 * 
	 * @param channel
	 *            The channel to send the message to. Non-null.
	 * @param embedObj
	 *            The embed object. Non-null.
	 * @param imageFileStream
	 *            The image file stream. Non-null.
	 * @param fileName
	 *            The file name that is to be shown in Discord. Must be
	 *            alphanumeric. Non-null.
	 */
	void sendEmbed(IChannel channel, EmbedObject embedObj, InputStream imageFileStream, String fileName);
	
	/**
	 * Synchronously sends an embed object with an image. Will retry if
	 * RateLimitException is returned by Discord.
	 * 
	 * @param channel
	 *            The channel to send the message to. Non-null.
	 * @param embedObj
	 *            The embed object. Non-null.
	 * @param imageFileStream
	 *            The image file stream. Non-null.
	 * @param fileName
	 *            The file name that is to be shown in Discord. Must be
	 *            alphanumeric. Non-null.
	 * @return The sent embed message.
	 */
	IMessage sendEmbedSync(IChannel channel, EmbedObject embedObj, InputStream imageFileStream, String fileName);
}
