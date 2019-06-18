package micronaut.spock.mock.bug;

import javax.inject.Singleton;

/**
 * @author Silvio Wangler
 */
@Singleton
public class SuperServiceImpl implements SuperService {
    @Override
    public String hello(String name) {
        return String.format("Hello %s", name);
    }
}
