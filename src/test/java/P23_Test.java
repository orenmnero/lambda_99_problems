import com.jnape.palatable.lambda.adt.Maybe;
import com.jnape.palatable.lambda.adt.hlist.Tuple2;
import com.jnape.palatable.lambda.functions.Fn1;
import com.jnape.palatable.lambda.io.IO;
import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

import static com.jnape.palatable.lambda.adt.hlist.HList.tuple;
import static com.jnape.palatable.lambda.functions.builtin.fn1.CatMaybes.catMaybes;
import static com.jnape.palatable.lambda.functions.builtin.fn1.Constantly.constantly;
import static com.jnape.palatable.lambda.functions.builtin.fn1.Distinct.distinct;
import static com.jnape.palatable.lambda.functions.builtin.fn1.Repeat.repeat;
import static com.jnape.palatable.lambda.functions.builtin.fn1.Size.size;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Iterate.iterate;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Map.map;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Snoc.snoc;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Take.take;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Tupler2.tupler;
import static com.jnape.palatable.lambda.functions.builtin.fn3.FoldLeft.foldLeft;
import static com.jnape.palatable.lambda.io.IO.io;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static testsupport.matchers.IOMatcher.yieldsValue;
import static testsupport.matchers.IterableMatcher.iterates;

public class P23_Test {
    public static <T> IO<Iterable<T>> extractAGivenNumberOfRandomlySelectedElementsFromAList(
            Fn1<Integer, IO<Integer>> randomNumberGenerator,
            int n,
            Iterable<T> iterable) {

        return io(() -> {
            Tuple2<Iterable<Maybe<T>>, Iterable<T>> folded = foldLeft(
                    (moveBetween, generateRandomNumber) -> {
                        Integer randomNumber = generateRandomNumber.unsafePerformIO();
                        return tuple(
                                snoc(P03_Test.findTheKthElementOfAList(randomNumber, moveBetween._2()), moveBetween._1()),
                                P20_Test.removeTheKthElementFromAlist(randomNumber, moveBetween._2())
                        );
                    },
                    tupler(Collections::emptyIterator, iterable),
                    map(randomNumberGenerator::apply, take(n, iterate(i -> i - 1, size(iterable).intValue())))
            );

            return catMaybes(folded._1());
        });
    }

    @Test
    public void extractAGivenNumberOfRandomlySelectedElementsFromAList() {
        take(1000, repeat(io(() -> {
            assertEquals(Long.valueOf(3), size(distinct(extractAGivenNumberOfRandomlySelectedElementsFromAList(
                    size -> io(() -> ThreadLocalRandom.current().nextInt(size) + 1), 3, asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h')
            ).unsafePerformIO())));
        }))).forEach(IO::unsafePerformIO);

        assertThat(extractAGivenNumberOfRandomlySelectedElementsFromAList(
                constantly(io(new LinkedList<>(asList(1, 1, 1))::pop)), 3, asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h')
        ), yieldsValue(iterates('a', 'b', 'c')));

        assertThat(extractAGivenNumberOfRandomlySelectedElementsFromAList(
                IO::io, 3, asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h')
        ), yieldsValue(iterates('h', 'g', 'f')));

        assertThat(extractAGivenNumberOfRandomlySelectedElementsFromAList(
                constantly(io(new LinkedList<>(asList(4, 4, 4))::pop)), 3, asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h')
        ), yieldsValue(iterates('d', 'e', 'f')));
    }
}
