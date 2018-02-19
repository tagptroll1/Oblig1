package Deque.Tests;
import Deque.ArrayDeque;
import Deque.Exceptions.DequeEmptyException;
import Deque.ResizeableArrayDeque;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ArrayDequeTestClass {
    private ArrayDeque<Integer> deque;
    private ResizeableArrayDeque<Integer> rDeque;


    @BeforeEach
    void setup() {
        deque = new ArrayDeque<>(10);
        rDeque = new ResizeableArrayDeque<>(11);
        deque.addFirst(3);
        deque.addFirst(2);
        deque.addLast(4);
        deque.addLast(5);
        deque.addFirst(1);


        rDeque.addFirst(1);
        rDeque.addFirst(2);
        rDeque.addLast(3);
        rDeque.addFirst(4);
        rDeque.addLast(5);

    }

    @Test
    void testAddFirst(){
        deque.addFirst(0);
        assertEquals(Integer.valueOf(0), deque.peekFirst());

        rDeque.addFirst(0);
        assertEquals(Integer.valueOf(0), rDeque.peekFirst());

    }


    @Test
    void testAddLast(){
        deque.addLast(0);
        assertEquals(Integer.valueOf(0), deque.peekLast());

        rDeque.addLast(0);
        assertEquals(Integer.valueOf(0), rDeque.peekLast());
    }

    @Test
    void peekFirst() {
        assertEquals(Integer.valueOf(1), deque.peekFirst());
        assertEquals(Integer.valueOf(4), rDeque.peekFirst());
    }

    @Test
    void peekLast(){
        assertEquals(Integer.valueOf(5), deque.peekLast());
        assertEquals(Integer.valueOf(5), rDeque.peekLast());
    }

    @Test
    void pullTop(){
        assertEquals(5, deque.size());
        assertEquals(Integer.valueOf(1), deque.pullFirst());
        assertEquals(4, deque.size());
        assertEquals(Integer.valueOf(2), deque.peekFirst());

        assertEquals(5, rDeque.size());
        assertEquals(Integer.valueOf(4), rDeque.pullFirst());
        assertEquals(4, rDeque.size());
        assertEquals(Integer.valueOf(2), rDeque.peekFirst());
    }

    @Test
    void pullBot(){
        assertEquals(5, deque.size());
        assertEquals(Integer.valueOf(5), deque.pullLast());
        assertEquals(4, deque.size());
        assertEquals(Integer.valueOf(4), deque.peekLast());

        assertEquals(5, rDeque.size());
        assertEquals(Integer.valueOf(5), rDeque.pullLast());
        assertEquals(4, rDeque.size());
        assertEquals(Integer.valueOf(3), rDeque.peekLast());
    }

    @Test
    void testClear(){
        deque.clear();
        rDeque.clear();

        assertEquals(0, deque.size());
        assertEquals(0, rDeque.size());
        assertThrows(DequeEmptyException.class, () -> deque.peekFirst());
        assertThrows(DequeEmptyException.class, () -> deque.peekLast());
        assertThrows(DequeEmptyException.class, () -> rDeque.peekFirst());
        assertThrows(DequeEmptyException.class, () -> rDeque.peekLast());
    }

//    @Override
//    public void clearEntireDeque() {
//        deque.clear();
//    }
//
//    @Override
//    public void displayEntireArray() {
//        String[] dequeArray = deque.toArray(new String[0]);
//
//        for (String ele:dequeArray){
//            System.out.print("[" + ele + "] ");
//        }
//
//        System.out.println();
//    }
//
//    @Override
//    public void displaySize() {
//        System.out.println("Deque current size: " + deque.size());
//    }
//
//    @Override
//    public void isDequeFull() {
//        System.out.println("Deque is full? - " + deque.isArrayFull());
//    }
//
//    @Override
//    public void isDequeEmpty() {
//        System.out.println("Deque is empty? - " + deque.isArrayEmpty());
//    }
//
//    @Override
//    public void doesItContain(String element) {
//        System.out.println("Does deque contain: " + element + "? - " + deque.contains(element));
//    }
//
//    public void displayTopIndex(){
//        System.out.println("Deque topindex: " + deque.getTopIndex());
//    }
//
//    public void displayBotIndex(){
//        System.out.println("Deque Botindex: " + deque.getBotIndex());
//    }
//
//    /**
//     * The "behind the scenes" to addElementtoTop
//     * @param elements list of elements to be added
//     * @param deque the deque to be added to
//     * @return returns the deque
//     */
//    protected ArrayDeque<String> addToTop(String[] elements, ArrayDeque<String> deque){
//        int elementIndex = 0;
//        for (String ele : elements){
//
//            deque.addFirst(ele);
//
//            if (!deque.isArrayEmpty()){
//                System.out.println("Adding: " + elementIndex + " arrayIndex to " + deque.getTopIndex() +
//                        ". head-index, element: " + deque.peekFirst());
//            }
//            elementIndex++;
//        }
//        System.out.println("Current Head index is " + deque.getTopIndex());
//        return deque;
//    }
//
//    /**
//     * see addToTop
//     * @param elements Elements to be added to deque
//     * @param deque the deque
//     * @return filled deque
//     */
//    protected ArrayDeque<String> addToBot(String[] elements, ArrayDeque<String> deque){
//        int elementIndex = 0;
//        for (String ele : elements){
//            deque.addLast(ele);
//            if (!deque.isArrayEmpty()) {
//                System.out.println("Adding: " + elementIndex + " arrayIndex to " + deque.getBotIndex() +
//                        ". tail-index, element: " + deque.peekLast());
//            }
//            elementIndex++;
//        }
//        System.out.println("Current Tail index is " + deque.getBotIndex());
//        return deque;
//    }
//
}
