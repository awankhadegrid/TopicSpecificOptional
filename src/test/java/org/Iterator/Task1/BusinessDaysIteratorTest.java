package org.Iterator.Task1;

import org.Iterator.Task1.BusinessDaysIterator;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Iterator;

import static junit.framework.Assert.assertEquals;

class BusinessDaysIteratorTest {

    @Test
    void testWeekendStart() {
        Iterator<LocalDate> iter =
                new BusinessDaysIterator(LocalDate.of(2022, 1, 1));

        assertEquals(LocalDate.of(2022, 1, 3), iter.next());
        assertEquals(LocalDate.of(2022, 1, 4), iter.next());
        assertEquals(LocalDate.of(2022, 1, 5), iter.next());
    }

    @Test
    void testWeekdayStart() {
        Iterator<LocalDate> iter =
                new BusinessDaysIterator(LocalDate.of(2022, 1, 3));

        assertEquals(LocalDate.of(2022, 1, 4), iter.next());
        assertEquals(LocalDate.of(2022, 1, 5), iter.next());
    }
}