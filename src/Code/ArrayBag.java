package Code;

import java.util.Arrays;



public class ArrayBag<T> implements BagInterface<T> {
    T[] bag;
    int numberOfEntries;
    static final int DEFAULT_CAPACITY = 25;
    static final int MAX_CAPACITY = 10000;

    public ArrayBag(){
        this(DEFAULT_CAPACITY);
    }

    public ArrayBag(int capacity){
        if (capacity <= MAX_CAPACITY) {
            @SuppressWarnings("unchecked")
            T[] tempBag = (T[]) new Object[capacity];
            bag = tempBag;
            numberOfEntries = 0;
        } else {
            throw new IllegalStateException("Attempt to create a bag whose capacity exceeds max capacity");
        }
    }

    @Override
    public boolean add(T newEntry) {
        boolean result = true;
        if (isArrayFull()){
            result = false;
        }
        else
        {
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
        }
        return result;
    }

    @Override
    public boolean remove(T anEntry) {

        int index = getIndexOf(anEntry);
        if (index > -1){
            bag[index] = null;
            numberOfEntries--;
            return true;
        }
        return false;
    }

    private int getIndexOf(T anEntry){
        int where = -1;
        boolean stillLooking = true;
        int index = 0;

        while(stillLooking && index < numberOfEntries){
            if (anEntry.equals((bag[index]))){
                stillLooking = false;
                where = index;
            }
            index++;
        }
        return where;
    }


    @Override
    public void clear() {
        for (int i = 0; i < numberOfEntries; i++) {
            bag[i] = null;
        }
        numberOfEntries = 0;
    }

    @Override
    public boolean contains(T anEntry) {
        return getIndexOf(anEntry) > 1;
    }

    @Override
    public boolean isArrayFull() {
        return numberOfEntries >= bag.length;
    }

    @Override
    public int size() {
        return numberOfEntries;
    }

    @Override
    public int getMaxSize(){
        return bag.length;
    }

    @Override
    public Object[] toArray() {
        @SuppressWarnings("unchecked")
        T[]result = (T[])new Object[numberOfEntries];
        System.arraycopy(bag, 0, result,0,numberOfEntries);
        return result;
    }

    @Override
    public T[] toArray(T[] inputArray){
        @SuppressWarnings("unchecked")
        T[]result = (T[]) Arrays.copyOf(bag, numberOfEntries, inputArray.getClass());
        return result;

    }
}
