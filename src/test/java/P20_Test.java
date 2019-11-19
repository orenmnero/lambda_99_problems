import org.junit.Test;

import static com.jnape.palatable.lambda.functions.builtin.fn2.Drop.drop;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Take.take;
import static com.jnape.palatable.lambda.monoid.builtin.Concat.concat;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static testsupport.matchers.IterableMatcher.iterates;

public class P20_Test {
    public static <T> Iterable<T> removeTheKthElementFromAlist(int k, Iterable<T> iterable) {
        return concat(take(k - 1, iterable), drop(k, iterable));
    }

    @Test
    public void P20_removeTheKthElementFromAlist() {
        assertThat(
                removeTheKthElementFromAlist(2, asList('a', 'b', 'c', 'd')),
                iterates('a', 'c', 'd')
        );
    }
}
