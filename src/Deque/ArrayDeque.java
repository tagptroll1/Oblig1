package Deque;

import Deque.Exceptions.DequeEmptyException;
import Deque.Exceptions.DequeFullException;

public class ArrayDeque<E> implements ArrayDequeInterface<E>{
    static final int DEFAULT_CAPACITY = 32;

    public ArrayDeque() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayDeque(int capacity) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void addFirst(E elem) throws DequeFullException {

    }

    @Override
    public E pullFirst() throws DequeEmptyException {
        return null;
    }

    @Override
    public E peekFirst() throws DequeEmptyException {
        return null;
    }

    @Override
    public void addLast(E elem) throws DequeFullException {

    }

    @Override
    public E pullLast() throws DequeEmptyException {
        return null;
    }

    @Override
    public E peekLast() throws DequeEmptyException {
        return null;
    }

    @Override
    public boolean contains(Object elem) {
        return false;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public void clear() {

    }
}
