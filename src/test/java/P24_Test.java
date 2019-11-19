import com.jnape.palatable.lambda.adt.Maybe;
import com.jnape.palatable.lambda.adt.hlist.Tuple2;
import com.jnape.palatable.lambda.functions.Fn1;
import com.jnape.palatable.lambda.io.IO;
import org.junit.Test;

import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

import static com.jnape.palatable.lambda.adt.Maybe.just;
import static com.jnape.palatable.lambda.adt.Maybe.nothing;
import static com.jnape.palatable.lambda.adt.hlist.HList.tuple;
import static com.jnape.palatable.lambda.functions.builtin.fn1.CatMaybes.catMaybes;
import static com.jnape.palatable.lambda.functions.builtin.fn1.Constantly.constantly;
import static com.jnape.palatable.lambda.functions.builtin.fn1.Cycle.cycle;
import static com.jnape.palatable.lambda.functions.builtin.fn1.Distinct.distinct;
import static com.jnape.palatable.lambda.functions.builtin.fn1.Flatten.flatten;
import static com.jnape.palatable.lambda.functions.builtin.fn1.Head.head;
import static com.jnape.palatable.lambda.functions.builtin.fn1.Init.init;
import static com.jnape.palatable.lambda.functions.builtin.fn1.Last.last;
import static com.jnape.palatable.lambda.functions.builtin.fn1.Magnetize.magnetize;
import static com.jnape.palatable.lambda.functions.builtin.fn1.Repeat.repeat;
import static com.jnape.palatable.lambda.functions.builtin.fn1.Reverse.reverse;
import static com.jnape.palatable.lambda.functions.builtin.fn1.Size.size;
import static com.jnape.palatable.lambda.functions.builtin.fn2.All.all;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Cons.cons;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Drop.drop;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Eq.eq;
import static com.jnape.palatable.lambda.functions.builtin.fn2.InGroupsOf.inGroupsOf;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Into.into;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Iterate.iterate;
import static com.jnape.palatable.lambda.functions.builtin.fn2.LTE.lte;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Map.map;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Snoc.snoc;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Take.take;
import static com.jnape.palatable.lambda.functions.builtin.fn2.TakeWhile.takeWhile;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Tupler2.tupler;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Zip.zip;
import static com.jnape.palatable.lambda.functions.builtin.fn3.FoldLeft.foldLeft;
import static com.jnape.palatable.lambda.io.IO.io;
import static com.jnape.palatable.lambda.monoid.builtin.Concat.concat;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static testsupport.matchers.IOMatcher.yieldsValue;
import static testsupport.matchers.IterableMatcher.iterates;

public class P24_Test {
    public static IO<Iterable<Integer>> lottoDrawNDifferentRandomNumbersFromTheSet1ThruM(
            Fn1<Integer, IO<Integer>> randomNumberGenerator,
            int n,
            int m) {

        return P23_Test.extractAGivenNumberOfRandomlySelectedElementsFromAList(randomNumberGenerator, n, take(m, iterate(i -> i + 1, 1)));
    }

    @Test
    public void lottoDrawNDifferentRandomNumbersFromTheSet1ThruM() {
        assertThat(lottoDrawNDifferentRandomNumbersFromTheSet1ThruM(
                constantly(io(new LinkedList<>(asList(1, 1, 1, 1, 1, 1))::pop)), 6, 49
        ), yieldsValue(iterates(1, 2, 3, 4, 5, 6)));

        assertThat(lottoDrawNDifferentRandomNumbersFromTheSet1ThruM(
                IO::io, 6, 49
        ), yieldsValue(iterates(49, 48, 47, 46, 45, 44)));
    }
}
