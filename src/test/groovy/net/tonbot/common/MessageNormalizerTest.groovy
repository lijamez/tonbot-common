package net.tonbot.common

import spock.lang.Specification

class MessageNormalizerTest extends Specification {

	def "remove emojis"(String message, String expectedResult) {
		when:
		String result = MessageNormalizer.removeEmojis(message);
		
		then:
		result == expectedResult
		
		where:
		message                                         || expectedResult
		""                                              || ""
		"   "                                           || "   "
		"hello"                                         || "hello"
		":D"                                            || ":D"
		"hello 😃"                                      || "hello "
		"foo <a:ablobglarezoom:405565596407955456> bar" || "foo  bar"
		"foo <:blobglare:396521773102792724> bar"       || "foo  bar"
	}
}
