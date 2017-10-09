package net.tonbot.common;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * The route of an activity.
 */
@EqualsAndHashCode
public class Route {

	@Getter
	private final List<String> path;

	private final String routeAsString;

	private Route(List<String> routePath) {
		Preconditions.checkNotNull(routePath, "routePath must be non-null.");
		Preconditions.checkArgument(!routePath.isEmpty(), "routePath must not be empty.");

		routePath.forEach(element -> Preconditions.checkArgument(
				!StringUtils.isBlank(element), "routePath must not contain null or empty elements."));

		this.path = ImmutableList.copyOf(routePath.stream()
				.map(element -> element.trim())
				.collect(Collectors.toList()));
		this.routeAsString = StringUtils.join(this.path, " ");
	}

	/**
	 * Creates a {@link Route} from a string. The string should have each route path
	 * component separated by a space.<br/>
	 * Examples:<br/>
	 * 
	 * <pre>
	 * time
	 * </pre>
	 * 
	 * <pre>
	 * music play
	 * </pre>
	 * 
	 * @param routeStr
	 *            The route string. Must be non-null, non-blank.
	 * @return {@link Route}
	 */
	public static Route from(String routeStr) {
		Preconditions.checkArgument(!StringUtils.isBlank(routeStr), "routeStr must be non-null and not blank.");

		List<String> routePath = Arrays.asList(StringUtils.split(routeStr, " "));
		return new Route(routePath);
	}

	/**
	 * Creates a {@link Route from a route path.
	 * 
	 * @param routePath
	 *            The route path. Must be non-null and must not contain null or
	 *            blank elements. Elements will be trimmed.
	 * @return {@link Route}
	 */
	public static Route from(List<String> routePath) {
		return new Route(routePath);
	}

	/**
	 * Checks whether if the {@code otherRoute} is a prefix of this route.
	 * 
	 * @param otherRoute
	 *            The other route. Non-null.
	 * @return True if the other route is a prefix of this route. False otherwise.
	 */
	public boolean isPrefixedBy(Route otherRoute) {
		Preconditions.checkNotNull(otherRoute, "otherRoute must be non-null.");

		if (otherRoute.getPath().size() > path.size()) {
			return false;
		}

		Iterator<String> otherIt = otherRoute.getPath().iterator();
		Iterator<String> thisIt = this.path.iterator();
		while (otherIt.hasNext()) {
			if (!otherIt.next().equals(thisIt.next())) {
				return false;
			}
		}

		return true;
	}

	@Override
	public String toString() {
		return routeAsString;
	}
}
