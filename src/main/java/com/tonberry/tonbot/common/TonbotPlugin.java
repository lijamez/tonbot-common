package com.tonberry.tonbot.common;

import com.google.common.collect.ImmutableSet;

import java.util.Set;

/**
 * The Tonbot plugin loader will create an instance of this class using a 1-parameter constructor which accepts a
 * {@link TonbotPluginArgs}.
 */
public abstract class TonbotPlugin {

    public TonbotPlugin(TonbotPluginArgs pluginArgs) {

    }

    /**
     * Gets the human friendly name of the plugin.
     * @return The human friendly name of the plugin. Non-null.
     */
    public abstract String getFriendlyName();

    /**
     * Gets a short description of what this plugin does. This resulting sentence should be grammatically correct when
     * preceded by the words, "This plugin can..."
     * @return The action description. Non-null.
     */
    public abstract String getActionDescription();

    /**
     * Whether if this plugin should be hidden from the "help" menu.
     * @return True if this plugin should be hidden from the help menu. False otherwise.
     */
    public boolean isHidden() {
        return false;
    }

    /**
     * Gets the set of {@link Activity}.
     * @return The set of {@link Activity}. Non-null.
     */
    public Set<Activity> getActivities() {
        return ImmutableSet.of();
    }

    /**
     * Gets the set of {@link PeriodicTask}.
     * @return The set of {@link Activity}. Non-null.
     */
    public Set<PeriodicTask> getPeriodicTasks() {
        return ImmutableSet.of();
    }
}
