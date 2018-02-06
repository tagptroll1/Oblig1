package Deque;

import Deque.Exceptions.DequeFullException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Initializing Deque");
        ArrayDeque<String> deque = new ArrayDeque<>(7);
        String[] stuffToAdd = {"1", "2", "3"};
        String[] addToAss = {"Kek", "Hue", "ywwwww"};

        System.out.println("Adding elements to deques front: \n");
        for (String stuff : stuffToAdd){
            System.out.println("Added to first: " + stuff);
            try {
                deque.addFirst(stuff);
            } catch (DequeFullException e) {
                e.printStackTrace();
            }
        }



        System.out.println("Converting deque to array\n");
        System.out.println("Elements in array: \n");
        String[] newArray = deque.toArray(new String[0]);
        for(String elem: newArray){
            System.out.print("[" + elem + "], ");
        }


        for (String stuff : addToAss){

            try {
                System.out.println("Added to last: " + stuff);
                deque.addLast(stuff);
            } catch (DequeFullException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Elements in array: \n");
        String[] newNEWArray = deque.toArray(new String[0]);
        for(String elem: newNEWArray){
            System.out.println(elem);
        }


        Object[] dequeArray = deque.toArray();
        for (Object str : dequeArray) {
            System.out.print((String) str + ", ");
        }
    }
}
