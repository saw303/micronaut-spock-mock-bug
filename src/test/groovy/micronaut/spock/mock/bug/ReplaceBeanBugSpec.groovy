package micronaut.spock.mock.bug

import io.micronaut.test.annotation.MicronautTest
import io.micronaut.test.annotation.MockBean
import spock.lang.Specification
import spock.lang.Subject

import javax.inject.Inject

/**
 * This test specification demonstrates a bug introduced in Micronaut 1.1.3.
 *
 * When replacing a bean with a Spock test the mock only works in the first test as expected.
 *
 * When running the whole test suite -> test 1 is ok, test 2 fails
 * When running each test independently -> both are ok (independently)
 *
 * @author Silvio Wangler
 */
@MicronautTest
class ReplaceBeanBugSpec extends Specification {

    @Inject
    @Subject
    AnotherService anotherService

    @Inject
    SuperService superService

    @MockBean(SuperService)
    SuperService superService() {
        Mock(SuperService)
    }

    void "first test works"() {

        when:
        anotherService.greet("Silvio")

        then:
        1 * superService.hello("Silvio") >> "Good day Silvio"
        0 * _
    }

    void "second test works"() {

        when:
        anotherService.greet("Angela")

        then:
        1 * superService.hello("Angela") >> "Good day Angela"
        0 * _
    }
}
