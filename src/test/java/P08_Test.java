import org.junit.Test;

import static com.jnape.palatable.lambda.functions.builtin.fn1.CatMaybes.catMaybes;
import static com.jnape.palatable.lambda.functions.builtin.fn1.Head.head;
import static com.jnape.palatable.lambda.functions.builtin.fn1.Magnetize.magnetize;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Map.map;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static testsupport.matchers.IterableMatcher.iterates;

public class P08_Test {
    public static <T> Iterable<T> eliminateConsecutiveDuplicatesOfListElements(Iterable<T> iterable) {
        return catMaybes(map(head(), magnetize(iterable)));
    }

    @Test
    public void eliminateConsecutiveDuplicatesOfListElements() {
        assertThat(
                eliminateConsecutiveDuplicatesOfListElements(asList('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')),
                iterates('a', 'b', 'c', 'a', 'd', 'e')
        );
    }
}
