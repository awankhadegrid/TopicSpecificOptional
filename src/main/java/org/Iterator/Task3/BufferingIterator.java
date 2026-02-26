package org.Iterator.Task3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Iterator that groups elements from a source iterator
 * into batches (lists) of a given size.
 * The last batch may contain fewer elements.
 */
public class BufferingIterator<T> implements Iterator<List<T>> {

    private final Iterator<T> sourceIterator;
    private final int batchSize;

    public BufferingIterator(Iterator<T> sourceIterator, int batchSize) {
        this.sourceIterator = sourceIterator;
        this.batchSize = batchSize;
    }

    @Override
    public boolean hasNext() {
        return sourceIterator.hasNext();
    }

    @Override
    public List<T> next() {
        List<T> batch = new ArrayList<>();

        int count = 0;
        while (sourceIterator.hasNext() && count < batchSize) {
            batch.add(sourceIterator.next());
            count++;
        }

        return batch;
    }
}