package org.Iterator.Task3;

import org.Iterator.Task3.BufferingIterator;
import org.junit.jupiter.api.Test;
import java.util.Iterator;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class BufferingIteratorTest {

    @Test
    void testBatching() {

        Iterator<List<Integer>> iter =
                new BufferingIterator<>(
                        List.of(1, 2, 3, 4, 5).iterator(),
                        3
                );

        assertEquals(List.of(1, 2, 3), iter.next());
        assertEquals(List.of(4, 5), iter.next());
        assertFalse(iter.hasNext());
    }
}