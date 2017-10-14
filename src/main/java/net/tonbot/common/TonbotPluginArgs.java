package net.tonbot.common;

import java.awt.Color;
import java.io.File;

import com.google.common.base.Preconditions;

import lombok.Builder;
import lombok.Data;
import sx.blah.discord.api.IDiscordClient;

/**
 * A standard set of data passed to every Tonbot PluginResources. The config
 * file may or may not exist. If it does not, then the plugin may wish to create
 * it.
 */
@Data
@Builder
public class TonbotPluginArgs {

	private final String prefix;
	private final IDiscordClient discordClient;
	private final File configFile;
	private final BotUtils botUtils;
	private final Color color;

	private TonbotPluginArgs(
			String prefix, 
			IDiscordClient discordClient, 
			File configFile, 
			BotUtils botUtils,
			Color color) {
		this.prefix = Preconditions.checkNotNull(prefix, "prefix must be non-null.");
		this.discordClient = Preconditions.checkNotNull(discordClient, "discordClient must be non-null.");
		this.configFile = Preconditions.checkNotNull(configFile, "configFile must be non-null.");
		this.botUtils = Preconditions.checkNotNull(botUtils, "botUtils must be non-null.");
		this.color = Preconditions.checkNotNull(color, "color must be non-null.");
	}
}
