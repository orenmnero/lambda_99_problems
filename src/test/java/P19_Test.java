import org.junit.Test;

import static com.jnape.palatable.lambda.functions.builtin.fn1.Cycle.cycle;
import static com.jnape.palatable.lambda.functions.builtin.fn1.Size.size;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Drop.drop;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Take.take;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static testsupport.matchers.IterableMatcher.iterates;

public class P19_Test {
    public static <T> Iterable<T> rotateAListNPlacesToTheLeft(int n, Iterable<T> iterable) {
        return take(size(iterable).intValue(), drop(n, cycle(iterable)));
    }

    @Test
    public void rotateAListNPlacesToTheLeft() {
        assertThat(
                rotateAListNPlacesToTheLeft(3, asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h')),
                iterates('d', 'e', 'f', 'g', 'h', 'a', 'b', 'c')
        );
    }
}
