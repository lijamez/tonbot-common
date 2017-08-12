package com.tonberry.tonbot.common;

import java.util.Set;

/**
 * Tonbot uses classes of this type to instantiate {@link PluginResources}s.
 * The Tonbot plugin loader will create an instance of this class using a 1-parameter constructor which accepts a
 * {@link TonbotPluginArgs}.
 */
public interface TonbotPlugin {

    /**
     * Gets the human friendly name of the plugin.
     * @return The human friendly name of the plugin. Non-null.
     */
    String getFriendlyName();

    /**
     * Gets a short description of what this plugin does. This resulting sentence should be grammatically correct when
     * preceded by the words, "This plugin can..."
     * @return The action description. Non-null.
     */
    String getActionDescription();

    /**
     * Whether if this plugin should be hidden from the "help" menu.
     * @return True if this plugin should be hidden from the help menu. False otherwise.
     */
    boolean isHidden();

    /**
     * Gets the set of {@link Activity}.
     * @return The set of {@link Activity}. Non-null.
     */
    Set<Activity> getActivities();

    /**
     * Gets the set of {@link PeriodicTask}.
     * @return The set of {@link Activity}. Non-null.
     */
    Set<PeriodicTask> getPeriodicTasks();
}
