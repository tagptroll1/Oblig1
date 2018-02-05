package Code;

public interface BagInterface<T> {
    boolean add(T newEntry);

    boolean remove(T anEntry);

    void clear();

    boolean contains(T anEntry);

    boolean isArrayFull();

    int size();

    int getMaxSize();

    Object[] toArray();

    T[] toArray(T[] inputArray);
}
