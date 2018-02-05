package Demos;

import Code.BagInterface;
import Code.ArrayBag;

public class ArrayBagDemo1 {
    public static void main(String[] args) {
        // Adding to an initally empty bag with sufficient capacity
        System.out.println("Testing an initially empty bag with "+
                "the capacity to hold at least 6 strings:");
        BagInterface<String> aBag = new ArrayBag<>();

        String[] contentsOfBag1 = {"A", "A", "B", "A", "C", "A"};

        testAdd(aBag, contentsOfBag1);

        // Filling an initially empty bag to capacity
        System.out.println("\nTesting an initially empty bag that "+
                        "will be filled to capacity:");
        aBag = new ArrayBag<>(7);
        String[] contentsOfBag2 = {"A", "B", "A", "C", "B", "C", "D",
                                    "another string"};

        testAdd(aBag, contentsOfBag2);

        aBag = new ArrayBag<>(10000);
    }


    private static void testAdd(BagInterface<String> aBag, String[] content){
        System.out.println("adding the following "+ content.length +
                        " strings to the bag :");
        for (int i = 0; i <  content.length; i++) {
            if (aBag.add(content[i])){
                System.out.println(i + ". " + content[i] + " ");
            } else {
                System.out.println("\nUnable to add \"" + content[i]+
                                "\" to the bag.");
            }

        }
        System.out.println();
        displayBay(aBag);
    }

    //Tests the method toArray while displaying the bag
    private static void displayBay(BagInterface<String> aBag){
        System.out.println("The bag contains the following string(s):");
        Object[] bagArray = aBag.toArray();
        for (Object str : bagArray) {
            System.out.println(str + " ");
        }

        System.out.println();
    }
}
