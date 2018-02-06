package Deque;

import Deque.Exceptions.DequeFullException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Initializing Deque");
        ArrayDeque<String> deque = new ArrayDeque<>();
        String[] stuffToAdd = {"Balls", "Testies", "Banana"};

        System.out.println("Adding elements to deques front: \n");
        for (String stuff : stuffToAdd){
            try {
                deque.addFirst(stuff);
            } catch (DequeFullException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Converting deque to array\n");
        String[] newArray = deque.toArray(new String[0]);

        System.out.println("Elements in array: \n");
        for(String elem: newArray){
            System.out.println(elem);
        }
    }
}
