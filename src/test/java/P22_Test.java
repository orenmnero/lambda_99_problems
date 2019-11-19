import org.junit.Test;

import static com.jnape.palatable.lambda.functions.builtin.fn2.Iterate.iterate;
import static com.jnape.palatable.lambda.functions.builtin.fn2.LTE.lte;
import static com.jnape.palatable.lambda.functions.builtin.fn2.TakeWhile.takeWhile;
import static org.hamcrest.MatcherAssert.assertThat;
import static testsupport.matchers.IterableMatcher.iterates;

public class P22_Test {
    public static Iterable<Integer> createAListContainingAllIntegersWithinAGivenRange(int start, int end) {
        return takeWhile(lte(end), iterate(i -> i + 1, start));
    }

    @Test
    public void createAListContainingAllIntegersWithinAGivenRange() {
        assertThat(
                createAListContainingAllIntegersWithinAGivenRange(4, 9),
                iterates(4, 5, 6, 7, 8, 9)
        );
    }
}
