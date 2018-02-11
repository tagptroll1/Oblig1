package Deque;

import Deque.Exceptions.DequeEmptyException;
import Deque.Exceptions.DequeFullException;


public class ResizeableArrayDeque<E> extends ArrayDeque<E> {

    public ResizeableArrayDeque() {
        super();
    }

    public ResizeableArrayDeque(int capacity) {
        super(capacity);
    }

    private void growArray(){
        int newCapacity = deque.length * 2;
        if (newCapacity >= MAX_CAPACITY){
            throw new DequeFullException("Tried to expand deque past MAX Capacity");
        }
        //deque = Arrays.copyOf(deque, newCapacity);
        @SuppressWarnings("unchecked")
        E[] tempDeque = (E[]) new Object[newCapacity];
        for (int i = deque.length; i > 0; i--){
            if (!isArrayEmpty()){
                tempDeque[i] = pullLast();
            } else {
                throw new DequeEmptyException("Tried to pull element from empty deque");
            }
        }
        deque = tempDeque;
        topIndex = 0;
        botIndex = numberOfEntries;
    }

    @Override
    public void addFirst(E elem){
        if (isArrayFull()){
            growArray();
        }
        deque[topIndex = dec(topIndex, deque.length)] = elem;
        numberOfEntries ++;
    }

    @Override
    public void addLast(E elem){
        if (isArrayFull()){
            growArray();
        }
        deque[botIndex] = elem;
        numberOfEntries ++;
        botIndex = inc(botIndex, deque.length);
    }
}
