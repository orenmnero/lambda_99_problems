import org.junit.Test;

import static com.jnape.palatable.lambda.functions.builtin.fn1.Flatten.flatten;
import static com.jnape.palatable.lambda.functions.builtin.fn1.Repeat.repeat;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Map.map;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Take.take;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static testsupport.matchers.IterableMatcher.iterates;

public class P15_Test {
    public static <T> Iterable<T> replicateTheElementsOfAListAGivenNumberOfTimes(int n, Iterable<T> iterable) {
        return flatten(map(value -> take(n, repeat(value)), iterable));
    }

    @Test
    public void replicateTheElementsOfAListAGivenNumberOfTimes() {
        assertThat(
                replicateTheElementsOfAListAGivenNumberOfTimes(3, asList('a', 'b', 'c')),
                iterates('a', 'a', 'a', 'b', 'b', 'b', 'c', 'c', 'c')
        );
    }
}
