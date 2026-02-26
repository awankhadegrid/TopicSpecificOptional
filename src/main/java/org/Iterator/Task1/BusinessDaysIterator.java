package org.Iterator.Task1;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Iterator;
/**
 * An infinite iterator that generates business days starting from a given date.
 *
 * <p>This iterator skips Saturdays and Sundays and always returns the next
 * available business day (Monday–Friday).</p>
 *
 * <p>The iterator is infinite because future business days never end.
 * Therefore, {@link #hasNext()} always returns true.</p>
 *
 * @param startDate the starting date from which business days are calculated
 */
public class BusinessDaysIterator implements Iterator<LocalDate> {

    private LocalDate currentDate;

    //constructor that we use for the passing set date
    public BusinessDaysIterator(LocalDate startDate) {
        this.currentDate = startDate;
    }

    //making iterator infinite
    @Override
    public boolean hasNext() {
        return true;
    }

    //this method when we call so it check date every time
    @Override
    public LocalDate next() {

        currentDate = currentDate.plusDays(1);

        // skip Saturday and Sunday if current day is saturday and sunday then it's simply adding 1 day
        //so it go on the next day after condition false return current date
        while (currentDate.getDayOfWeek() == DayOfWeek.SATURDAY ||
                currentDate.getDayOfWeek() == DayOfWeek.SUNDAY) {

            currentDate = currentDate.plusDays(1);
        }

        return currentDate;
    }

    public static void main(String[] args) {

        Iterator<LocalDate> iter =
                new BusinessDaysIterator(LocalDate.of(2022, 1, 3));

        System.out.println("First business day: " + iter.next());
        System.out.println("Second business day: " + iter.next());
        System.out.println("Third business day: " + iter.next());
        System.out.println("Fourth business day: " + iter.next());
        System.out.println("Fifth business day: " + iter.next());
    }
}