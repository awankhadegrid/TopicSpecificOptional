package org.Iterator.Task4;

import org.junit.jupiter.api.Test;
import java.util.Iterator;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FlatteningIteratorTest {

    @Test
    void testFlattening() {

        Iterator<Integer> iter = new FlatteningIterator<>(
                List.of(42, 5).iterator(),
                List.of(-4).iterator(),
                List.of(999, 998, 997).iterator()
        );

        assertEquals(42, iter.next());
        assertEquals(5, iter.next());
        assertEquals(-4, iter.next());
        assertEquals(999, iter.next());
        assertEquals(998, iter.next());
        assertEquals(997, iter.next());
        assertFalse(iter.hasNext());
    }
}