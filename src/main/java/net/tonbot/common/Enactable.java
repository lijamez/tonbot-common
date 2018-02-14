package net.tonbot.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates to Tonbot that the annotated method should be invoked instead of
 * the Activity's standard enact method. This annotation should be used on a
 * method with a MessageReceivedEvent parameter and optionally, an object to map
 * arguments to.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Enactable {

}
