import com.jnape.palatable.lambda.adt.hlist.Tuple2;
import org.junit.Test;

import static com.jnape.palatable.lambda.adt.hlist.HList.tuple;
import static com.jnape.palatable.lambda.functions.builtin.fn1.CatMaybes.catMaybes;
import static com.jnape.palatable.lambda.functions.builtin.fn1.Head.head;
import static com.jnape.palatable.lambda.functions.builtin.fn1.Magnetize.magnetize;
import static com.jnape.palatable.lambda.functions.builtin.fn1.Size.size;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Map.map;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Tupler2.tupler;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static testsupport.matchers.IterableMatcher.iterates;

public class P10_Test {
    public static <T> Iterable<Tuple2<Long, T>> runLengthEncodingOfAList(Iterable<T> iterable) {
        return catMaybes(
                map(magnetized -> head(magnetized).fmap(tupler(size(magnetized))),
                        magnetize(iterable))
        );
    }

    @Test
    public void runLengthEncodingOfAList() {
        assertThat(
                runLengthEncodingOfAList(asList('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')),
                iterates(tuple(4L, 'a'), tuple(1L, 'b'), tuple(2L, 'c'), tuple(2L, 'a'), tuple(1L, 'd'), tuple(4L, 'e'))
        );
    }
}
