package Deque;

import Deque.Exceptions.DequeEmptyException;
import Deque.Tests.ArrayDequeTestClass;
import Deque.Tests.ArrayDequesTestInterface;

public class Main {
    public static void main(String[] args) {
        ArrayDequeTestClass tester = new ArrayDequeTestClass();
        /* Functions available to tester:

            boolean testAddingTopElements(); // Top decrements index values as it grows
            boolean testAddingBottomElements(); // Bot increases index values as it grows
            getDeque()
            getDefaultDeque()
            void peekAtTop();
            void peekAtBot();
            void pullFromTop();
            void pullFromBot();
            void clearEntireDeque();
            void displayEntireArray();
            void displaySize();
            void isDequeFull();
            void isDequeEmpty();
            void doesItContain(E element);
         */
        tester.testAddingTopElements();

        ArrayDeque<String> deque = tester.getDeque();
        for (int i = 0; i < 3; i++) {
            try {
                deque.pullLast();
            } catch (DequeEmptyException e) {
                e.printStackTrace();
            }
        }

        tester.testAddingBottomElements();
        tester.peekAtTop();
        tester.peekAtBot();
        tester.displayTopIndex();
        tester.displayBotIndex();
        tester.displayEntireArray();
        tester.pullFromBot();
        tester.pullFromTop();
        tester.displayEntireArray();
        tester.displaySize();
        tester.isDequeEmpty();
        tester.isDequeFull();

        String testElement;
        try {
            testElement = deque.peekFirst();
            tester.doesItContain(testElement);
        } catch (DequeEmptyException e) {
            e.printStackTrace();
        }
        tester.clearEntireDeque();
    }
}
