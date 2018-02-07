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
        topIndex = capacity;
        botIndex = 0;
    }


    private static int inc(int i, int modulus) {
        if (++i >= modulus) i = 0;
        return i;
    }


    private static int dec(int i, int modulus) {
        if (--i < 0) i = modulus - 1;
        return i;
    }

    public int getBotIndex() {
        return botIndex;
    }

    public int getTopIndex(){
        return topIndex;
    }

    @Override
    public int size() {
        return numberOfEntries;
    }

    @Override
    public boolean isArrayFull(){
        return (topIndex == botIndex && numberOfEntries > 0);
    }

    @Override
    public boolean isArrayEmpty(){
        return (topIndex == botIndex && numberOfEntries <= 0);
    }

    @Override
    public void addFirst(E elem) throws DequeFullException {
        if (isArrayFull()){
            throw new DequeFullException("sumting made top to bot");
        }
        deque[topIndex = dec(topIndex, deque.length)] = elem;
        numberOfEntries ++;
    }

    @Override
    public E pullFirst() throws DequeEmptyException {
        if (isArrayEmpty()){
            throw new DequeEmptyException("Deque doesn't contain any entries");
        }
        E temp = deque[topIndex];
        deque[topIndex] = null;
        topIndex = inc(topIndex, deque.length);
        numberOfEntries--;
        return temp;
    }

    @Override
    public E peekFirst() throws DequeEmptyException {
        if (isArrayEmpty()){
            throw new DequeEmptyException("Deque doesn't contain any entries");
        }
        return deque[topIndex];
    }

    @Override
    public void addLast(E elem) throws DequeFullException {
        if (isArrayFull() && topIndex == (botIndex = inc(botIndex, deque.length))){
            throw new DequeFullException("Sumting wong");
        }
        deque[botIndex] = elem;
        numberOfEntries ++;

    }

    @Override
    public E pullLast() throws DequeEmptyException {
        if (isArrayEmpty()){
            throw new DequeEmptyException("Deque doesn't contain any entries");
        }
        E temp = deque[dec(botIndex, deque.length)];
        deque[botIndex = dec(botIndex, deque.length)] = null;
        numberOfEntries--;
        return temp;
    }

    @Override
    public E peekLast() throws DequeEmptyException {
        if (isArrayEmpty()) {
            throw new DequeEmptyException("Deque doesn't contain any entries");
        }
        return deque[dec(botIndex, deque.length)];
    }

    @Override
    public boolean contains(E inputElem) {
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
        E[]result = (E[])new Object[deque.length];
        System.arraycopy(deque, 0, result,0,deque.length);
        return result;
    }

    @Override
    public E[] toArray(E[] a){
        @SuppressWarnings("unchecked")
        E[]result = (E[]) Arrays.copyOf(deque, deque.length, a.getClass());
        return result;
    }

    @Override
    public void clear() {
        Arrays.fill(deque, null);
        numberOfEntries = 0;
    }
}
