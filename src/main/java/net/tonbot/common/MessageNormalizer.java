package net.tonbot.common;

import com.google.common.base.Preconditions;
import com.vdurmont.emoji.EmojiParser;

public class MessageNormalizer {

	// Supports both static and animated emotes.
	private static final String CUSTOM_EMOJI_REGEX = "<a?:[A-Za-z0-9_]{2,}:\\d+>";

	private MessageNormalizer() {
	}

	/**
	 * Removes UTF-8 emojis and Discord's custom emojis. Does not remove ASCII
	 * emoticons.
	 * 
	 * @param message
	 *            The messsage. Non-null.
	 * @return The normalized message with all emojis removed.
	 */
	public static String removeEmojis(String message) {
		Preconditions.checkNotNull(message, "message must be non-null.");

		String normalizedMessage = message;

		// Removes the standard UTF-8 emojis.
		normalizedMessage = EmojiParser.removeAllEmojis(normalizedMessage);

		// Remove custom emojis
		normalizedMessage = normalizedMessage.replaceAll(CUSTOM_EMOJI_REGEX, "");

		return normalizedMessage;
	}
}
