package Deque;

import Deque.Exceptions.DequeEmptyException;
import Deque.Exceptions.DequeFullException;

import java.util.Arrays;

public class ArrayDeque<E> implements IDeque<E> {
    private E[] deque;
    private int numberOfEntries;
    private int topIndex; // Head of Deque
    private int botIndex; // Tail of Deque
    private static final int DEFAULT_CAPACITY = 32;
    private static final int MAX_CAPACITY = 10000;

    public ArrayDeque(){
        this(DEFAULT_CAPACITY);
    }

    public ArrayDeque(int capacity){
        if (capacity >= MAX_CAPACITY) {
            capacity = MAX_CAPACITY;
        }

        @SuppressWarnings("unchecked")
        E[] tempDeque = (E[]) new Object[capacity];
        deque = tempDeque;
        numberOfEntries = 0;
        topIndex = capacity - 1;
        botIndex = 0;

    }

    private int getTop(){
        return (topIndex - 1) & (deque.length - 1);
    }

    @Override
    public int size() {
        return numberOfEntries;
    }

    @Override
    public boolean isArrayFull(){
        return (topIndex == botIndex && numberOfEntries != 0);
    }

    @Override
    public boolean isArrayEmpty(){
        return (topIndex == botIndex && numberOfEntries <= 0);
    }

    @Override
    public void addFirst(E elem) throws DequeFullException {
        if (isArrayFull()) {
            throw new DequeFullException("Deque size exeeds deque's capacity");
        }
        //TODO topIndex - 1 add element if topIndex-1 != botIndex
        deque[getTop()] = elem;
        numberOfEntries ++;
    }

    @Override
    public E pullFirst() throws DequeEmptyException {
        if (isArrayEmpty()){
            throw new DequeEmptyException("Deque doesn't contain any entries");
        }
        //TODO First er ikke nøvendigvis fremst i arrayet fixie fix
        topIndex = getTop();
        E temp = deque[topIndex];
        deque[topIndex] = null;
        numberOfEntries--;
        return temp;
    }

    @Override
    public E peekFirst() throws DequeEmptyException {
        if (isArrayEmpty()){
            throw new DequeEmptyException("Deque doesn't contain any entries");
        }
        return deque[getTop()];
    }

    @Override
    public void addLast(E elem) throws DequeFullException {
        if (isArrayFull()){
            throw new DequeFullException("Deque size exeeds deque's capacity");
        }
        deque[botIndex] = elem;
        botIndex = (botIndex++) % deque.length;
        numberOfEntries++;
    }

    @Override
    public E pullLast() throws DequeEmptyException {
        if (isArrayEmpty()){
            throw new DequeEmptyException("Deque doesn't contain any entries");
        }
        botIndex = (botIndex - 1) & (deque.length - 1);
        E temp = deque[botIndex];
        deque[botIndex] = null;
        numberOfEntries--;
        return temp;
    }

    @Override
    public E peekLast() throws DequeEmptyException {
        if (isArrayEmpty()) {
            throw new DequeEmptyException("Deque doesn't contain any entries");
        }
        return deque[botIndex];
    }

    @Override
    public boolean contains(Object inputElem) {
        if (isArrayEmpty()) {
            return false;
        }

        for(E ele : deque){
            if (ele.equals(inputElem)){
                return true;
            }
        }
        return false;
    }
    @Override
    public Object[] toArray() {
        @SuppressWarnings("unchecked")
        E[]result = (E[])new Object[numberOfEntries];
        System.arraycopy(deque, 0, result,0,numberOfEntries);
        return result;
    }

    @Override
    public E[] toArray(E[] a){
        @SuppressWarnings("unchecked")
        E[]result = (E[]) Arrays.copyOf(deque, numberOfEntries, a.getClass());
        return result;
    }

    @Override
    public void clear() {
        Arrays.fill(deque, null);
        numberOfEntries = 0;
    }
}
