import org.junit.Test;

import static com.jnape.palatable.lambda.functions.builtin.fn2.Cons.cons;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Drop.drop;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Take.take;
import static com.jnape.palatable.lambda.monoid.builtin.Concat.concat;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static testsupport.matchers.IterableMatcher.iterates;

public class P21_Test {
    public static <T> Iterable<T> insertAnElementAtAGivenPositionInAList(int k, T element, Iterable<T> iterable) {
        return concat(take(k - 1, iterable), cons(element, drop(k - 1, iterable)));
    }

    @Test
    public void insertAnElementAtAGivenPositionInAList() {
        assertThat(
                insertAnElementAtAGivenPositionInAList(2, 'Z', asList('a', 'b', 'c', 'd')),
                iterates('a', 'Z', 'b', 'c', 'd')
        );
    }
}
