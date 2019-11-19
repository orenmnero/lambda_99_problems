import com.jnape.palatable.lambda.adt.Maybe;
import org.junit.Test;

import static com.jnape.palatable.lambda.adt.Maybe.just;
import static com.jnape.palatable.lambda.functions.builtin.fn1.Init.init;
import static com.jnape.palatable.lambda.functions.builtin.fn1.Last.last;
import static java.util.Arrays.asList;
import static junit.framework.TestCase.assertEquals;

public class P02_Test {
    public static <T> Maybe<T> findTheLastButOneBoxOfAList(Iterable<T> iterable) {
        return last(init(iterable));
    }

    @Test
    public void findTheLastButOneBoxOfAList() {
        assertEquals(just('c'), findTheLastButOneBoxOfAList(asList('a', 'b', 'c', 'd')));
    }
}
