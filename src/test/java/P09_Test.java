import org.junit.Test;

import static com.jnape.palatable.lambda.functions.builtin.fn1.Magnetize.magnetize;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static testsupport.matchers.IterableMatcher.iterates;

public class P09_Test {
    public static <T> Iterable<Iterable<T>> packConsecutiveDuplicatesOfListElementsIntoSublists(Iterable<T> iterable) {
        return magnetize(iterable);
    }

    @Test
    public void packConsecutiveDuplicatesOfListElementsIntoSublists() {
        assertThat(
                packConsecutiveDuplicatesOfListElementsIntoSublists(asList('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')),
                iterates(asList('a', 'a', 'a', 'a'), asList('b'), asList('c', 'c'), asList('a', 'a'), asList('d'), asList('e', 'e', 'e', 'e'))
        );
    }
}
