package Deque.Tests;

public interface ArrayDequesTestInterface {
    boolean testAddingTopElements(); // Top decrements index values as it grows
    boolean testAddingBottomElements(); // Bot increases index values as it grows
    void peekAtTop();
    void peekAtBot();
    void pullFromTop();
    void pullFromBot();
    void clearEntireDeque();
    void displayEntireArray();
    void displaySize();
    void isDequeFull();
    void isDequeEmpty();
    void doesItContain(String element);

}
