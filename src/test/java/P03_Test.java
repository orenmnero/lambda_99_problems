import com.jnape.palatable.lambda.adt.Maybe;
import org.junit.Test;

import static com.jnape.palatable.lambda.adt.Maybe.just;
import static com.jnape.palatable.lambda.adt.Maybe.nothing;
import static com.jnape.palatable.lambda.functions.builtin.fn1.Head.head;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Drop.drop;
import static java.util.Arrays.asList;
import static junit.framework.TestCase.assertEquals;

public class P03_Test {
    public static <T> Maybe<T> findTheKthElementOfAList(int k, Iterable<T> iterable) {
        return head(drop(k - 1, iterable));
    }

    @Test
    public void findTheKthElementOfAList() {
        assertEquals(just('c'), findTheKthElementOfAList(3, asList('a', 'b', 'c', 'd', 'e')));
        assertEquals(nothing(), findTheKthElementOfAList(3, asList('a', 'b')));
    }
}
