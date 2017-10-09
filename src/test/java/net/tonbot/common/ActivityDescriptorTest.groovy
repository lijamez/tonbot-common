package net.tonbot.common

import com.google.common.collect.ImmutableList

import spock.lang.Specification

class ActivityDescriptorTest extends Specification {

	def "construction - happy case"() {
		when:
		ActivityDescriptor ad = ActivityDescriptor.builder()
				.route("foo bar")
				.parameters(["param1", "param2"])
				.description("Test Description")
				.usageDescription("Test Usage Description")
				.build()

		then:
		ad.getDescription() == "Test Description"
		ad.getUsageDescription().get() == "Test Usage Description"
		ad.getParameters() == ["param1", "param2"]
		ad.getRoute() == Route.from("foo bar")
	}

	def "construction with invalid route"(String routeStr) {
		when:
		ActivityDescriptor.builder()
				.route(routeStr)
				.parameters(["param1", "param2"])
				.description("Test Description")
				.usageDescription("Test Usage Description")
				.build()

		then:
		thrown IllegalArgumentException

		where:
		routeStr | _
		""       | _
		" "      | _
	}

	def "ActivityDescriptor must have a route"() {
		when:
		ActivityDescriptor.builder()
				.route(null)
				.parameters(["param1", "param2"])
				.description("Test Description")
				.usageDescription("Test Usage Description")
				.build()

		then:
		thrown NullPointerException
	}

	def "ActivityDescriptor defaults description to an empty string"() {
		when:
		ActivityDescriptor ad = ActivityDescriptor.builder()
				.route("foo bar")
				.parameters(["param1", "param2"])
				.usageDescription("Test Usage Description")
				.build()

		then:
		ad.getDescription() == ""
	}

	def "ActivityDescriptor defaults null arguments to empty list"() {
		when:
		ActivityDescriptor ad = ActivityDescriptor.builder()
				.route("foo bar")
				.usageDescription("Test Usage Description")
				.build()

		then:
		ad.getParameters() == []
	}

	def "the returned parameters must be immutable"() {
		when:
		ActivityDescriptor ad = ActivityDescriptor.builder()
				.route("foo bar")
				.parameters(["param1", "param2"])
				.usageDescription("Test Usage Description")
				.build()

		then:
		ad.getParameters() instanceof ImmutableList
	}
}
