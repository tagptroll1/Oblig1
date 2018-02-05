package Demos;

import Code.ResizeableArrayBag;
import Code.BagInterface;

public class ResizeableArrayBagDemo {
    public static void main(String[] args) {
        // Adding to an initally empty bag with sufficient capacity
        System.out.println("Testing an initially empty bag with "+
                "the capacity to hold at least 6 strings:");
        BagInterface<String> rBag = new ResizeableArrayBag<>();


        String[] contentsofrBag1 = {"He", "He", "Ha", "Hi", "Hi"};

        testrAdd(rBag, contentsofrBag1);

        // Filling an initially empty bag to capacity
        System.out.println("\nTesting an initially empty bag that "+
                "will be filled to capacity:");

        rBag = new ResizeableArrayBag<>(7);
        String[] contentsOfrBag2 = {"He", "He", "Ha", "Hi", "Hi", "C", "D",
                "another stringuuu"};


        testrAdd(rBag, contentsOfrBag2);
    }

    private static void testrAdd(BagInterface<String> rBag, String[] content){
        System.out.println("adding the following "+ content.length +
                " strings to the bag :");
        for (int i = 0; i <  content.length; i++) {
            if (rBag.add(content[i])){
                System.out.println(i + ". " + content[i] + " ");
            }
        }
        System.out.println("Size of ResizableBag is now: " + rBag.size());
        System.out.println("Current max size is: " + rBag.getMaxSize());
        System.out.println();
        displayBay(rBag);
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
