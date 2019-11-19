import com.jnape.palatable.lambda.adt.Maybe;
import org.junit.Test;

import static com.jnape.palatable.lambda.adt.Maybe.just;
import static com.jnape.palatable.lambda.functions.builtin.fn1.Last.last;
import static java.util.Arrays.asList;
import static junit.framework.TestCase.assertEquals;

public class P01_Test {
    public static <T> Maybe<T> findTheLastBoxOfAList(Iterable<T> iterable) {
        return last(iterable);
    }

    @Test
    public void findTheLastBoxOfAList() {
        assertEquals(just('d'), findTheLastBoxOfAList(asList('a', 'b', 'c', 'd')));
    }
}
