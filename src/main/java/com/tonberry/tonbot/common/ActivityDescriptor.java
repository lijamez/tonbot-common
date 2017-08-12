package com.tonberry.tonbot.common;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
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

        this.parameters = parameters != null ? parameters : ImmutableList.of();
        this.description = description != null ? description : "";
        this.usageDescription = usageDescription;
    }

    public Optional<String> getUsageDescription() {
        return Optional.ofNullable(usageDescription);
    }
}
