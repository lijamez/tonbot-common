package com.tonberry.tonbot.common;

import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

import java.util.List;
import java.util.Optional;

public interface Activity {

    /**
     * Gets the route.
     * @return The route. Non-null, non-empty.
     */
    List<String> getRoute();

    /**
     * Gets a description of this activity.
     * @return A description of what this activity does. Non-null.
     */
    String getDescription();

    /**
     * Gets a usage description.
     * @return A description on how to use this activity. Non-null. May be empty.
     */
    Optional<String> getUsage();

    void enact(MessageReceivedEvent event, String args);
}
