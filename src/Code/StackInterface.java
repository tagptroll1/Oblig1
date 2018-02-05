package Code;

public interface StackInterface<T> {

    /**Adds a new entry to the top of the stack
     * @param newEntry the entry to be added to the stack*/
    void push(T newEntry);

    /**Alias for Code.StackInterface#push
     * @param newEntry entry to be added to the stack*/
    void add(T newEntry);

    /**Alias for Code.StackInterface#push
     * @param newEntry entry to be added to the stack*/
    void insert(T newEntry);

    /**Removes the top item from the stack
     * @return returns the item removed
     * @throws java.util.EmptyStackException if the stack is
     * empty before the operation*/
    T pop();

    /**Alias for Code.StackInterface#pop
     * @return returns the item removed
     * @throws java.util.EmptyStackException if the stack is
     * empty before the operation*/
    T pull();

    /**Alias for Code.StackInterface#pop
     * @return returns the item removed
     * @throws java.util.EmptyStackException if the stack is
     * empty before the operation*/
    T remove();

    /**Alias for Code.StackInterface#pop
     * @return returns the item removed
     * @throws java.util.EmptyStackException if the stack is
     * empty before the operation*/
    T delete();

    /**Gets the top item without removing it
     * @return returns the top item of the stack
     * @throws java.util.EmptyStackException if the stack is empty*/
    T peek();

    /**Alias for Code.StackInterface#peek
     * @return returns the top item of the stack
     * @throws java.util.EmptyStackException if the stack is empty*/
    T getTop();

    /**Checks if the stack is empty or not
     * @return returns True if the stack is empty, false if not.*/
    boolean isEmpty();

    /**Clears the stack of entries, returns nothing.*/
    void clear();
}
