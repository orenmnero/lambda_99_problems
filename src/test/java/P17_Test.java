import com.jnape.palatable.lambda.adt.hlist.Tuple2;
import org.junit.Test;

import static com.jnape.palatable.lambda.adt.hlist.HList.tuple;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Drop.drop;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Take.take;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static testsupport.matchers.IterableMatcher.iterates;

public class P17_Test {
    public static <T> Tuple2<Iterable<T>, Iterable<T>> splitTheListIntoTwoParts(int n, Iterable<T> iterable) {
        return tuple(take(n, iterable), drop(n, iterable));
    }

    @Test
    public void splitTheListIntoTwoParts() {
        Tuple2<Iterable<Character>, Iterable<Character>> split = splitTheListIntoTwoParts(
                3, asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'k'));

        assertThat(split._1(), iterates('a', 'b', 'c'));
        assertThat(split._2(), iterates('d', 'e', 'f', 'g', 'h', 'i', 'k'));
    }
}
