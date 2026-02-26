package org.Iterator.Task2;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Iterator;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ZippingIteratorTest {

    @Test
    void testAddition() {

        Iterator<Integer> it1 = Arrays.asList(1, 2, 3).iterator();
        Iterator<Integer> it2 = Arrays.asList(10, 20, 30).iterator();

        ZippingIterator<Integer, Integer, Integer> zipped =
                new ZippingIterator<>(it1, it2, Integer::sum);

        assertEquals(11, zipped.next());
        assertEquals(22, zipped.next());
        assertEquals(33, zipped.next());
    }
}