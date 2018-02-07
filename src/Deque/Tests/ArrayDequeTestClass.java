package Deque.Tests;
import Deque.ArrayDeque;
import Deque.Exceptions.DequeEmptyException;
import Deque.Exceptions.DequeFullException;

import java.util.Arrays;

public class ArrayDequeTestClass implements ArrayDequesTestInterface {
    private ArrayDeque<String> defaultDeque;
    private ArrayDeque<String> deque;

    public ArrayDequeTestClass(){
        deque = new ArrayDeque<>(5); // Preset size of 5
        defaultDeque = new ArrayDeque<>(); // Default size deque
    }

    public ArrayDeque<String> getDeque() {
        return deque;
    }

    public ArrayDeque<String> getDefaultDeque() {
        return defaultDeque;
    }

    @Override
    public boolean testAddingTopElements() {
        boolean returnValue = true;
        String[] firstArray = {"Text", "String", "1", "2"};
        String[] secondArray = {"Text", "from", "second"};
        System.out.println("Adding " + Arrays.toString(firstArray) + " to deque");

        try {
            deque = addToTop(firstArray, deque);
        } catch (DequeFullException e) {
            e.printStackTrace();
            returnValue = false;
        }

        System.out.println("Adding " + Arrays.toString(secondArray) + " to defaultdeque");

        try {
            defaultDeque = addToTop(secondArray, defaultDeque);
        } catch (DequeFullException e) {
            e.printStackTrace();
            returnValue = false;
        }
        System.out.println();
        return returnValue;
    }

    @Override
    public boolean testAddingBottomElements() {
        boolean returnValue = true;
        String[] firstArray = {"bottom", "text", "1", "2"};
        String[] secondArray = {"Text", "from", "second"};
        System.out.println("Adding " + Arrays.toString(firstArray) + " to deques bottom");

        try {
            deque = addToBot(firstArray, deque);
        } catch (DequeFullException e) {
            e.printStackTrace();
            returnValue = false;
        }

        System.out.println("Adding " + Arrays.toString(secondArray) + " to defaultdeques bottom");

        try {
            defaultDeque = addToBot(secondArray, defaultDeque);
        } catch (DequeFullException e) {
            e.printStackTrace();
            returnValue = false;
        }
        System.out.println();
        return returnValue;
    }

    @Override
    public void peekAtTop() {

        String deqFirst = null;
        try {
            deqFirst = deque.peekFirst();
        } catch (DequeEmptyException e) {
            e.printStackTrace();
        }
        System.out.println("Top element on deque is: " + deqFirst);

        String deqSecond = null;
        try {
            deqSecond = defaultDeque.peekFirst();
        } catch (DequeEmptyException e) {
            e.printStackTrace();
        }
        System.out.println("Top element on defaultdeque is: " + deqSecond);
        System.out.println();
    }

    @Override
    public void peekAtBot() {
        String deqFirst = null;
        try {
            deqFirst = deque.peekLast();
        } catch (DequeEmptyException e) {
            e.printStackTrace();
        }
        System.out.println("Bot element on deque is: " + deqFirst);

        String deqSecond = null;
        try {
            deqSecond = defaultDeque.peekLast();
        } catch (DequeEmptyException e) {
            e.printStackTrace();
        }
        System.out.println("Bot element on defaultdeque is: " + deqSecond);
        System.out.println();
    }


    @Override
    public void pullFromTop() {
        System.out.println("Pulling first element from deque:");
        String deqFirst;
        try {
            deqFirst = deque.pullFirst();
            System.out.println(deqFirst);
        } catch (DequeEmptyException e) {
            e.printStackTrace();
        }

        System.out.println("Pulling first element from defaultdeque:");
        String deqSecond;
        try {
            deqSecond = defaultDeque.pullFirst();
            System.out.println(deqSecond);
        } catch (DequeEmptyException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    @Override
    public void pullFromBot() {
        System.out.println("Pulling last element from deque:");
        String deqFirst;
        try {
            deqFirst = deque.pullLast();
            System.out.println(deqFirst);
        } catch (DequeEmptyException e) {
            e.printStackTrace();
        }

        System.out.println("Pulling last element from defaultdeque:");
        String deqSecond;
        try {
            deqSecond = defaultDeque.pullLast();
            System.out.println(deqSecond);
        } catch (DequeEmptyException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    @Override
    public void clearEntireDeque() {
        deque.clear();
        defaultDeque.clear();
    }

    @Override
    public void displayEntireArray() {
        String[] dequeArray = deque.toArray(new String[0]);
        String[] defaultArray = defaultDeque.toArray(new String[0]);

        for (String ele:dequeArray){
            System.out.print("[" + ele + "] ");
        }
        System.out.println();
        for (String ele: defaultArray){
            System.out.print("[" + ele +"]");
        }
        System.out.println();
    }

    @Override
    public void displaySize() {
        System.out.println("Deque current size: " + deque.size());
        System.out.println("Deafult deque current size: " + defaultDeque.size());
    }

    @Override
    public void isDequeFull() {
        System.out.println("Deque is full? - " + deque.isArrayFull());
        System.out.println("Defaultdeque is full? - " + defaultDeque.isArrayFull());
    }

    @Override
    public void isDequeEmpty() {
        System.out.println("Deque is full? - " + deque.isArrayEmpty());
        System.out.println("Defaultdeque is full? - " + defaultDeque.isArrayEmpty());
    }

    @Override
    public void doesItContain(Object element) {
        System.out.println("Does deque contain: " + element + "? - " + deque.contains((String)element));
        System.out.println("Does defaultdeque contain: " + element + "? - " + defaultDeque.contains((String)element));
    }

    public void displayTopIndex(){
        System.out.println("Deque topindex: " + deque.getTopIndex());
        System.out.println("defaultDeque topindex: " + defaultDeque.getTopIndex());
    }

    public void displayBotIndex(){
        System.out.println("Deque Botindex: " + deque.getBotIndex());
        System.out.println("defaultDeque Botindex: " + defaultDeque.getBotIndex());
    }

    private ArrayDeque<String> addToTop(String[] elements, ArrayDeque<String> deque) throws DequeFullException{
        for (String ele : elements){
            deque.addFirst(ele);
        }
        return deque;
    }

    private ArrayDeque<String> addToBot(String[] elements, ArrayDeque<String> deque) throws DequeFullException{
        for (String ele : elements){
            deque.addLast(ele);
        }
        return deque;
    }

}
