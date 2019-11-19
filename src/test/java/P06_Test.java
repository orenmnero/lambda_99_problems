import org.junit.Test;

import static com.jnape.palatable.lambda.functions.builtin.fn1.Reverse.reverse;
import static com.jnape.palatable.lambda.functions.builtin.fn2.All.all;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Eq.eq;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Into.into;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Zip.zip;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class P06_Test {
    public static <T> boolean findOutWhetherAListIsAPalindrome(Iterable<T> iterable) {
        return all(into(eq()), zip(iterable, reverse(iterable)));
    }

    @Test
    public void findOutWhetherAListIsAPalindrome() {
        assertTrue(findOutWhetherAListIsAPalindrome(emptyList()));
        assertTrue(findOutWhetherAListIsAPalindrome(asList('x', 'a', 'm', 'a', 'x')));
        assertFalse(findOutWhetherAListIsAPalindrome(asList('y', 'a', 'm', 'a', 'x')));
    }
}
