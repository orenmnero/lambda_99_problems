import org.junit.Test;

import static com.jnape.palatable.lambda.functions.builtin.fn1.Flatten.flatten;
import static com.jnape.palatable.lambda.functions.builtin.fn2.InGroupsOf.inGroupsOf;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Map.map;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Take.take;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static testsupport.matchers.IterableMatcher.iterates;

public class P16_Test {
    public static <T> Iterable<T> dropEveryNthElementFromAList(int n, Iterable<T> iterable) {
        return flatten(map(group -> take(n - 1, group), inGroupsOf(n, iterable)));
    }

    @Test
    public void dropEveryNthElementFromAList() {
        assertThat(
                dropEveryNthElementFromAList(3, asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'k')),
                iterates('a', 'b', 'd', 'e', 'g', 'h', 'k')
        );
    }
}
