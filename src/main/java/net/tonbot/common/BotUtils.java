package net.tonbot.common;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.internal.json.objects.EmbedObject;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.util.RequestBuilder;

/**
 * A helper class to send data to discord. Thread safe.
 */
public class BotUtils {

	private final IDiscordClient discordClient;
	
	@Inject
	public BotUtils(IDiscordClient discordClient) {
		this.discordClient = Preconditions.checkNotNull(discordClient, "discordClient must be non-null.");
	}

	/**
	 * Asynchronously sends a message. Will retry if a RateLimitException is returned by Discord.  
	 * @param channel The channel to send the message to. Non-null.
	 * @param message The message to be sent. Must be non-null, non-empty.
	 */
	public void sendMessage(IChannel channel, String message) {
		Preconditions.checkNotNull(channel, "channel must be non-null.");
		Preconditions.checkNotNull(message, "message must be non-null.");
		
		new RequestBuilder(discordClient)
			.shouldBufferRequests(true)
			.setAsync(true)
			.doAction(() -> {
				channel.sendMessage(message);
				return true;
			})
			.execute();
	}

	/**
	 * Asynchronously sends an embed object. Will retry if RateLimitException is returned by Discord.
	 * @param channel The channel to send the message to. Non-null.
	 * @param embedObj The embed object. Non-null.
	 */
	public void sendEmbed(IChannel channel, EmbedObject embedObj) {
		Preconditions.checkNotNull(channel, "channel must be non-null.");
		Preconditions.checkNotNull(embedObj, "embedObj must be non-null.");
		
		new RequestBuilder(discordClient)
				.shouldBufferRequests(true)
				.setAsync(true)
				.doAction(() -> {
					channel.sendMessage(embedObj);
					return true;
				})
				.execute();
	}
}
