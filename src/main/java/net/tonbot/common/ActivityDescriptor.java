package net.tonbot.common;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

import lombok.Builder;
import lombok.Data;

/**
 * An activity descriptor.<br/>
 * 
 * <p>
 * route: The canonical route for this activity. Required. Must not be blank.
 * </p>
 * <p>
 * description: A optional <i>brief</i> description of what the command does.
 * </p>
 * <p>
 * usageDescription: An optional <i>comprehensive</i> description of what the
 * command does and how to use it. When this description is displayed, any
 * supported placeholders will be replaced with real values. Placeholders are to
 * be formatted like so: <code>${placeholderName}</code><br/>
 * Supported placeholders:
 * <ul>
 * <li>absoluteReferencedRoute: The full route, including Tonbot prefix, that
 * was used to reference this activity. This could be the canonical route of the
 * activity or one of its aliases.</li>
 * </ul>
 * </p>
 */
@Data
public class ActivityDescriptor {

	private final Route route;

	private final List<Route> routeAliases;

	private final List<String> parameters;

	private final String description;

	private final String usageDescription;

	@Builder
	private ActivityDescriptor(
			String route,
			List<String> routeAliases,
			List<String> parameters,
			String description,
			String usageDescription) {
		Preconditions.checkNotNull(route, "route must be non-null.");
		Preconditions.checkArgument(!route.isEmpty(), "route must be non-empty.");

		this.route = Route.from(route);

		if (routeAliases != null) {
			this.routeAliases = routeAliases.stream()
					.map(aliasStr -> Route.from(aliasStr))
					.collect(Collectors.toList());
		} else {
			this.routeAliases = ImmutableList.of();
		}

		this.parameters = parameters != null ? ImmutableList.copyOf(parameters) : ImmutableList.of();
		this.description = description != null ? description : "";
		this.usageDescription = usageDescription;
	}

	public Optional<String> getUsageDescription() {
		return Optional.ofNullable(usageDescription);
	}
}
