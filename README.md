# Custom Iterator Implementations in Java

This project contains four custom iterator implementations demonstrating advanced usage of the Java Iterator interface and generics.

---

## 1️⃣ BusinessDaysIterator

An infinite iterator that returns the next business day (Monday–Friday) starting from a given date.

- Skips Saturday and Sunday
- hasNext() always returns true
- Uses LocalDate

---

## 2️⃣ ZippingIterator

Combines two iterators element-by-element using a BiFunction.

- Takes one element from each iterator
- Applies a combining function
- Stops when either iterator is exhausted

Example:
(1,2,3) + (10,20,30) → (11,22,33)

---

## 3️⃣ BufferingIterator

Groups elements from a source iterator into batches of a given size.

- Returns List<T>
- Last batch may contain fewer elements

Example:
(1,2,3,4,5) with size 3 → [1,2,3] [4,5]

---

## 4️⃣ FlatteningIterator

Flattens multiple iterators into a single iterator.

- Preserves order
- Automatically moves to next iterator when one finishes

Example:
(42,5), (-4), (999,998,997)
→ 42 5 -4 999 998 997

---

## Concepts Covered

- Iterator interface
- Generics
- Functional interfaces (BiFunction)
- State management
- Batch processing
- Iterator composition

---

Author: Abhishek Wankhade
