package Deque;

import Deque.Exceptions.DequeEmptyException;
import Deque.Tests.ArrayDequeTestClass;
import Deque.Tests.ArrayDequesTestInterface;

public class Main {
    public static void main(String[] args) {
        ArrayDequeTestClass tester = new ArrayDequeTestClass();

        // Tests Adding elements, peaks at the current top and displays the array for debug
        tester.testAddingTopElements();
        tester.peekAtTop();
        tester.displayEntireArray();

        // Tests adding element to the bottom of the deque, peek at bottom and display array
        tester.testAddingBottomElements();
        tester.peekAtBot();
        tester.displayEntireArray();

        // Tries to pull from top and bottom, displays array and size afterwards
        tester.pullFromTop();
        tester.pullFromBot();
        tester.displayEntireArray();
        tester.displaySize();

        // Internal checks if array is full or empty
        tester.isDequeEmpty();
        tester.isDequeFull();

        // Fetch the deque out, gets first element and checks if its in the deque, so always true
        ArrayDeque<String> deque = tester.getDeque();
        String testElement;

        try {
            System.out.println(deque.peekFirst() + " - first element" );
            System.out.println(deque.peekLast() + " - last element" );
        } catch (DequeEmptyException e) {
            e.printStackTrace();
        }

        try {
            testElement = deque.peekFirst();
            tester.doesItContain(testElement);
        } catch (DequeEmptyException e) {
            e.printStackTrace();
        }

        // Clears the deque, and checks if it's cleared correct
        tester.clearEntireDeque();
        tester.isDequeFull();
        tester.isDequeEmpty();
        System.out.println("Head and tail ");
        deque.getTopIndex();
        deque.getBotIndex();

    }
}
