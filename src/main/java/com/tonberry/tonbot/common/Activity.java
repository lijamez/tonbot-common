package com.tonberry.tonbot.common;

import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

public interface Activity {

    /**
     * Gets the {@link ActivityDescriptor}.
     * @return {@link ActivityDescriptor}. Non-null.
     */
    ActivityDescriptor getDescriptor();

    void enact(MessageReceivedEvent event, String args);
}
