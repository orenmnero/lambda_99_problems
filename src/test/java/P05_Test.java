import org.junit.Test;

import static com.jnape.palatable.lambda.functions.builtin.fn1.Reverse.reverse;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static testsupport.matchers.IterableMatcher.iterates;

public class P05_Test {
    public static <T> Iterable<T> reverseAList(Iterable<T> iterable) {
        return reverse(iterable);
    }

    @Test
    public void reverseAList() {
        assertThat(reverseAList(asList('a', 'b', 'c', 'd')), iterates('d', 'c', 'b', 'a'));
    }
}
