package Deque;

import Deque.Exceptions.DequeEmptyException;
import Deque.Exceptions.DequeFullException;

public class ArrayDeque<E> implements IDeque<E> {
    private E[] deque;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 32;
    private static final int MAX_CAPACITY = 10000;

    public ArrayDeque() throws DequeFullException {
        this(DEFAULT_CAPACITY);
    }

    public ArrayDeque(int capacity) throws DequeFullException {
        if (capacity <= MAX_CAPACITY){
            @SuppressWarnings("unchecked")
            E[] tempDeque = (E[]) new Object[capacity];
            deque = tempDeque;
            numberOfEntries = 0;
        } else {
            throw new DequeFullException("Attempt to create a Deque whose size exeeds max capacity");
        }
    }

    @Override
    public int size() {
        return numberOfEntries;
    }

    @Override
    public boolean isArrayFull(){
        return numberOfEntries >= deque.length;
    }

    @Override
    public boolean isArrayEmpty(){
        return numberOfEntries <= 0;
    }

    @Override
    public void addFirst(E elem) throws DequeFullException {
        if (isArrayFull()){
            throw new DequeFullException("Deque size exeeds deque's capacity");
        } else {

        }
    }

    @Override
    public E pullFirst() throws DequeEmptyException {
        if (isArrayEmpty()){
            for (int i = 0; i < deque.length ; i ++){
                if (deque[i] != null){
                    E temp = deque[i];
                    deque[i] = null;
                    return temp;
                }
            }
        } else {
            throw new DequeEmptyException("Deque doesn't contain any entries");
        }
        return null;
    }

    @Override
    public E peekFirst() throws DequeEmptyException {
        if (isArrayEmpty()){
            throw new DequeEmptyException("Deque doesn't contain any entries");
        } else {
            for (E ele : deque){
                if (ele != null){
                    return ele;
                }
            }
        }
        return null; // Safety thing
    }

    @Override
    public void addLast(E elem) throws DequeFullException {
        if (isArrayFull()){
            throw new DequeFullException("Deque size exeeds deque's capacity");
        } else {

        }
    }

    @Override
    public E pullLast() throws DequeEmptyException {
        if (isArrayEmpty()){
            throw new DequeEmptyException("Deque doesn't contain any entries");
        } else {

        }
        return null;
    }

    @Override
    public E peekLast() throws DequeEmptyException {
        if (isArrayEmpty()) {
            throw new DequeEmptyException("Deque doesn't contain any entries");
        } else {

        }
        return null;
    }

    @Override
    public boolean contains(Object elem) {
        return false;
    }

    @Override
    public <E> E[] toArray(E[] a) {
        return null;
    }

    @Override
    public void clear() {
        for (int i = 0; i < deque.length; i++){
            deque[i] = null;
        }
    }
}
