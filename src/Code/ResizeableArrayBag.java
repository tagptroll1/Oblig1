package Code;

import java.util.Arrays;



public class ResizeableArrayBag<T> extends ArrayBag<T>{

    public ResizeableArrayBag(){
        this(DEFAULT_CAPACITY);
    }

    public ResizeableArrayBag(int capacity){
        super(capacity);
    }

    private void checkCapacity(int capacity){
        if (capacity > MAX_CAPACITY){
            throw new IllegalStateException("Attempted to create a bag whose"
                                            + "capacity exceeds allowed "
                                            + "maximum of " + MAX_CAPACITY);
        }
    }

    private void doubleCapacity(){
        int newLength = 2 * bag.length;
        checkCapacity(newLength);
        bag = Arrays.copyOf(bag, newLength);
    }

    @Override
    public boolean add(T newEntry) {
        if (isArrayFull()) {
            doubleCapacity();
        }

        bag[numberOfEntries] = newEntry;
        numberOfEntries++;

        return true;
    }
}
