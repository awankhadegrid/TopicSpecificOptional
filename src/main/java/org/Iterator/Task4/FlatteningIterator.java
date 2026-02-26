package org.Iterator.Task4;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Iterator that merges multiple iterators into a single iterator
 * and returns elements in the original order.
 */
public class FlatteningIterator<T> implements Iterator<T> {

    private final List<Iterator<T>> iterators;
    private int currentIndex = 0;

    public FlatteningIterator(Iterator<T>... iterators) {
        this.iterators = List.of(iterators);
    }

    @Override
    public boolean hasNext() {
        while (currentIndex < iterators.size()) {

            if (iterators.get(currentIndex).hasNext()) {
                return true;
            }

            currentIndex++; // move to next iterator
        }

        return false;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        return iterators.get(currentIndex).next();
    }
    public static void main(String[] args) {

        Iterator<Integer> iter = new FlatteningIterator<>(
                List.of(42, 5).iterator(),
                List.of(-4).iterator(),
                List.of(999, 998, 997).iterator()
        );

        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
    }
}