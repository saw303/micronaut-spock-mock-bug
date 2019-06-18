package micronaut.spock.mock.bug;

import javax.inject.Singleton;

/**
 * @author Silvio Wangler
 */
@Singleton
public class AnotherService {

    private final SuperService superService;

    public AnotherService(SuperService superService) {
        this.superService = superService;
    }

    public String greet(String name) {
        return superService.hello(name);
    }
}
