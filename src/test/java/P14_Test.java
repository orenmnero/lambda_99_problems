import org.junit.Test;

import static com.jnape.palatable.lambda.functions.builtin.fn1.Flatten.flatten;
import static com.jnape.palatable.lambda.functions.builtin.fn1.Repeat.repeat;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Map.map;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Take.take;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static testsupport.matchers.IterableMatcher.iterates;

public class P14_Test {
    public static <T> Iterable<T> duplicateTheElementsOfAList(Iterable<T> iterable) {
        return flatten(map(value -> take(2, repeat(value)), iterable));
    }

    @Test
    public void duplicateTheElementsOfAList() {
        assertThat(
                duplicateTheElementsOfAList(asList('a', 'b', 'c', 'c', 'd')),
                iterates('a', 'a', 'b', 'b', 'c', 'c', 'c', 'c', 'd', 'd')
        );
    }
}
