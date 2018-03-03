package net.tonbot.common;

import java.io.InputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
	 * Asynchronously sends a message. Will retry if a RateLimitException is
	 * returned by Discord. Message will be deleted after the given amount of time.
	 * 
	 * @param channel
	 *            The channel to send the message to. Non-null.
	 * @param message
	 *            The message to be sent. Must be non-null, non-empty.
	 * @param long
	 *            The delay before deleting the message.
	 * @param timeUnit
	 *            The unit of time for the {@code delay}. Non-null.
	 */
	void sendMessage(IChannel channel, String message, long delay, TimeUnit timeUnit);

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
	 * Asynchronously sends an embed object. Will retry if RateLimitException is
	 * returned by Discord. Message will be deleted after the given amount of time.
	 * 
	 * @param channel
	 *            The channel to send the message to. Non-null.
	 * @param embedObj
	 *            The embed object. Non-null.
	 * @param long
	 *            The delay before deleting the message.
	 * @param timeUnit
	 *            The unit of time for the {@code delay}. Non-null.
	 */
	void sendEmbed(IChannel channel, EmbedObject embedObj, long delay, TimeUnit timeUnit);

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

	/**
	 * Asynchronously and quietly deletes messages. Will retry if RateLimitException
	 * is returned by Discord.
	 * 
	 * @param messages
	 *            The list of messages to delete. Non-null.
	 */
	void deleteMessagesQuietly(List<IMessage> messages);

	/**
	 * Asynchronously and quietly deletes messages. Will retry if RateLimitException
	 * is returned by Discord.
	 * 
	 * @param messages
	 *            The messages to delete. Non-null.
	 */
	void deleteMessagesQuietly(IMessage... message);
}
