import org.junit.Test;

import static com.jnape.palatable.lambda.functions.builtin.fn1.Size.size;
import static java.util.Arrays.asList;
import static junit.framework.TestCase.assertEquals;

public class P04_Test {
    public static <T> long findTheNumberOfElementsOfAList(Iterable<T> iterable) {
        return size(iterable);
    }

    @Test
    public void findTheNumberOfElementsOfAList() {
        assertEquals(4L, findTheNumberOfElementsOfAList(asList('a', 'b', 'c', 'd')));
    }
}
