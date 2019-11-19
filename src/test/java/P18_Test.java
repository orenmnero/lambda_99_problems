import org.junit.Test;

import static com.jnape.palatable.lambda.functions.builtin.fn2.Drop.drop;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Take.take;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static testsupport.matchers.IterableMatcher.iterates;

public class P18_Test {
    public static <T> Iterable<T> extractASliceFromAList(int start, int end, Iterable<T> iterable) {
        return take(end - start + 1, drop(start - 1, iterable));
    }

    @Test
    public void extractASliceFromAList() {
        assertThat(
                extractASliceFromAList(3, 7, asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'k')),
                iterates('c', 'd', 'e', 'f', 'g')
        );
    }
}
