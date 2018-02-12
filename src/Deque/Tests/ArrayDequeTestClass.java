package Deque.Tests;
import Deque.ArrayDeque;
import Deque.Exceptions.DequeEmptyException;
import Deque.Exceptions.DequeFullException;

import java.util.Arrays;

public class ArrayDequeTestClass implements ArrayDequesTestInterface {
    protected ArrayDeque<String> deque;

    public ArrayDequeTestClass(){
        deque = new ArrayDeque<>(10); // Preset size of 5
    }

    public ArrayDeque<String> getDeque() {
        return deque;
    }


    /**
     * Adds 1 string to deque for fine testing
     * @param a string to be added
     */
    public void addOneEntryTobot(String a){

        if (!deque.isArrayFull()){
            deque.addLast(a);
        }
    }

    @Override
    public void testAddingTopElements() {
        String[] firstArray = {"1", "2", "3", "4"};
        System.out.println("Adding " + Arrays.toString(firstArray) + " to deque");


        deque = addToTop(firstArray, deque);
        System.out.println();
    }

    @Override
    public void testAddingBottomElements() {
        String[] firstArray = {"a","b","c","d"};
        System.out.println("Adding " + Arrays.toString(firstArray) + " to deques bottom");

        if (!deque.isArrayFull()){
            deque = addToBot(firstArray, deque);
        }

        System.out.println();
    }

    @Override
    public void peekAtTop() {

        String deqFirst = null;
        if (!deque.isArrayEmpty()){
            deqFirst = deque.peekFirst();
        }
        System.out.println("Top element on deque is: " + deqFirst);
        System.out.println();
    }

    @Override
    public void peekAtBot() {
        String deqFirst = null;
        if(!deque.isArrayEmpty()){
            deqFirst = deque.peekLast();
        }
        System.out.println("Bot element on deque is: " + deqFirst);

        System.out.println();
    }


    @Override
    public void pullFromTop() {
        System.out.println("Pulling first element from deque:");
        String deqFirst;
        if (!deque.isArrayEmpty()){
            deqFirst = deque.pullFirst();
            System.out.println(deqFirst + " pulled, current head index: " + deque.getTopIndex());
        }

        System.out.println();
    }

    @Override
    public void pullFromBot() {
        System.out.println("Pulling last element from deque:");
        String deqFirst;
        if (!deque.isArrayEmpty()){
            deqFirst = deque.pullLast();
            System.out.println(deqFirst+ " pulled, current tail index: " + deque.getBotIndex());
        }

        System.out.println();
    }

    @Override
    public void clearEntireDeque() {
        deque.clear();
    }

    @Override
    public void displayEntireArray() {
        String[] dequeArray = deque.toArray(new String[0]);

        for (String ele:dequeArray){
            System.out.print("[" + ele + "] ");
        }

        System.out.println();
    }

    @Override
    public void displaySize() {
        System.out.println("Deque current size: " + deque.size());
    }

    @Override
    public void isDequeFull() {
        System.out.println("Deque is full? - " + deque.isArrayFull());
    }

    @Override
    public void isDequeEmpty() {
        System.out.println("Deque is empty? - " + deque.isArrayEmpty());
    }

    @Override
    public void doesItContain(String element) {
        System.out.println("Does deque contain: " + element + "? - " + deque.contains(element));
    }

    public void displayTopIndex(){
        System.out.println("Deque topindex: " + deque.getTopIndex());
    }

    public void displayBotIndex(){
        System.out.println("Deque Botindex: " + deque.getBotIndex());
    }

    /**
     * The "behind the scenes" to addElementtoTop
     * @param elements list of elements to be added
     * @param deque the deque to be added to
     * @return returns the deque
     */
    protected ArrayDeque<String> addToTop(String[] elements, ArrayDeque<String> deque){
        int elementIndex = 0;
        for (String ele : elements){

            deque.addFirst(ele);

            if (!deque.isArrayEmpty()){
                System.out.println("Adding: " + elementIndex + " arrayIndex to " + deque.getTopIndex() +
                        ". head-index, element: " + deque.peekFirst());
            }
            elementIndex++;
        }
        System.out.println("Current Head index is " + deque.getTopIndex());
        return deque;
    }

    /**
     * see addToTop
     * @param elements Elements to be added to deque
     * @param deque the deque
     * @return filled deque
     */
    protected ArrayDeque<String> addToBot(String[] elements, ArrayDeque<String> deque){
        int elementIndex = 0;
        for (String ele : elements){
            deque.addLast(ele);
            if (!deque.isArrayEmpty()) {
                System.out.println("Adding: " + elementIndex + " arrayIndex to " + deque.getBotIndex() +
                        ". tail-index, element: " + deque.peekLast());
            }
            elementIndex++;
        }
        System.out.println("Current Tail index is " + deque.getBotIndex());
        return deque;
    }

}
