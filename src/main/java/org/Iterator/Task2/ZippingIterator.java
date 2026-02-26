package org.Iterator.Task2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.BiFunction;

/**
 * Iterator that combines elements from two input iterators
 * using a BiFunction and returns the combined result.
 * Stops when either iterator is exhausted.
 */
public class ZippingIterator<A, B, C> implements Iterator<C> {

    private final Iterator<A> iteratorA;
    private final Iterator<B> iteratorB;
    private final BiFunction<A, B, C> zipperFunction;

    //constructor for setting value
    public ZippingIterator(Iterator<A> iteratorA,
                           Iterator<B> iteratorB,
                           BiFunction<A, B, C> zipperFunction) {

        this.iteratorA = iteratorA;
        this.iteratorB = iteratorB;
        this.zipperFunction = zipperFunction;
    }

    @Override
    public boolean hasNext() {
        return iteratorA.hasNext() && iteratorB.hasNext();
    }

    @Override
    public C next() {
        A valueA = iteratorA.next();
        B valueB = iteratorB.next();
        return zipperFunction.apply(valueA, valueB);
    }

    public static void main(String[] args) {
        Iterator<Integer> it1 = Arrays.asList(1, 2, 3).iterator();
        Iterator<Integer> it2 = Arrays.asList(10, 20, 30).iterator();

        ZippingIterator<Integer, Integer, Integer> zipped =
                new ZippingIterator<>(it1, it2, (a, b) -> a + b);

        while (zipped.hasNext()) {
            System.out.println(zipped.next());
        }
    }
}