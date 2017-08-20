package net.tonbot.common;

import java.io.File;
import java.util.Optional;

import com.google.common.base.Preconditions;

import lombok.Builder;
import lombok.Data;
import sx.blah.discord.api.IDiscordClient;

/**
 * A standard set of data passed to every Tonbot PluginResources.
 */
@Data
@Builder
public class TonbotPluginArgs {

    private final String prefix;
    private final IDiscordClient discordClient;
    private final File configFile;
    private final BotUtils botUtils;

    private TonbotPluginArgs(String prefix, IDiscordClient discordClient, File configFile, BotUtils botUtils) {
        this.prefix = Preconditions.checkNotNull(prefix, "prefix must be non-null.");
        this.discordClient = Preconditions.checkNotNull(discordClient, "discordClient must be non-null.");
        this.configFile = configFile;
        this.botUtils = Preconditions.checkNotNull(botUtils, "botUtils must be non-null.");
    }

    public Optional<File> getConfigFile() {
        return Optional.ofNullable(configFile);
    }
}
