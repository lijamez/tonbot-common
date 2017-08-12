package com.tonberry.tonbot.common;

import com.google.common.base.Preconditions;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
@Builder
class ActivityDescriptor {

    private final List<String> route;

    private final List<String> parameters;

    private final String description;

    private final String usageDescription;

    private ActivityDescriptor(
            List<String> route,
            List<String> parameters,
            String description,
            String usageDescription) {
        Preconditions.checkNotNull(route, "route must be non-null.");
        Preconditions.checkArgument(!route.isEmpty(), "route must be non-empty.");
        route.stream()
                .forEach(routeComponent -> Preconditions.checkArgument(
                        !route.contains(" "), "Route components must not include spaces."));
        this.route = route;

        this.parameters = Preconditions.checkNotNull(parameters, "parameters must be non-null.");
        this.description = Preconditions.checkNotNull(description, "description must be non-null.");
        this.usageDescription = usageDescription;
    }

    public Optional<String> getUsageDescription() {
        return Optional.ofNullable(usageDescription);
    }
}
