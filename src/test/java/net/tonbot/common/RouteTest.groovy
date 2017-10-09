package net.tonbot.common

import spock.lang.Specification

class RouteTest extends Specification {

    def "toString test"(def inputRouteObj, String expectedRouteStr) {
        when:
        Route route = Route.from(inputRouteObj)
        
        then:
        route.toString() == expectedRouteStr
        
        where:
        inputRouteObj    || expectedRouteStr
        "foo"            || "foo"
        " foo "          || "foo"
        " foo bar "      || "foo bar"
        " foo  bar  "    || "foo bar"
        ["foo"]          || "foo"
        ["foo", "bar"]   || "foo bar"
        ["foo ", " bar"] || "foo bar"
    }
    
    def "invalid input test"(def inputRouteObj) {
        when:
        Route.from(inputRouteObj)
        
        then:
        thrown IllegalArgumentException
        
        where:
        inputRouteObj | _
        ""            | _
        "   "         | _
        "\t"          | _
        []            | _
        ["foo", ""]   | _
        [" "]         | _
    }
    
    def "isPrefixedBy test"(String routeStr, String prefix, boolean expectedResult) {
        when:
        boolean result = Route.from(routeStr).isPrefixedBy(Route.from(prefix))
        
        then:
        result == expectedResult
        
        where:
        routeStr | prefix    || expectedResult
        "a b c"  | "a b c"   || true
        "a b c"  | "a b"     || true
        "a b c"  | "a"       || true
        "a b c"  | "b"       || false
        "a b c"  | "a b c d" || false
    }
    
    def "equality test"(def route1Input, def route2Input, boolean expectedResult) {
        when:
        boolean result = Route.from(route1Input).equals(Route.from(route2Input))
        
        then:
        result == expectedResult
        
        where:
        route1Input   | route2Input || expectedResult
        "a b"         | "a b"       || true
        "a b"         | "a"         || false
        ["a"]         | "a"         || true
        [" a ", " b"] | "a b"       || true
    }
    
}
