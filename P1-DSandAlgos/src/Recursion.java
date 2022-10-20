import java.util.Arrays;

public class Recursion {

    /*
     * Find the index of an item in a list using recursion.
     * 
     * Implement a function that takes in an item and an array of items, and returns
     * the 0-based index of a sought item: >>> recursive_search(“hey”, [“hey”,
     * “there”, “you”]) 0
     * 
     * If the item isn’t in the list, return -1: >>> recursive_search(“porcupine”,
     * [“hey”, “there”, “you”]) -1
     * 
     * Important: Solve this problem only with recursion—you cannot use a for or
     * while loop in your solution!
     * 
     * What is the runtime of this function?
     */
    public static void main(String[] args) {

        String[] arr = { "hey", "there", "you" };
        String item = "hey";
        int index = recursiveSearch(item, arr);
        System.out.println("The index of the item is: " + index);

        String[] arr2 = { "hey", "there", "you" };
        String item2 = "porcupine";
        int index2 = recursiveSearch(item2, arr2);
        System.out.println("The index of the item is: " + index2);

        
    }

    public static int recursiveSearch(String item, String[] items) {

        item = item.toLowerCase();
        for (int i = 0; i < items.length; i++) {
            items[i] = items[i].toLowerCase();
        }

        if (items.length == 0) {
            return -1;
        }

        if (items[0].equals(item)) {
            return 0;
        }

        int index = recursiveSearch(item, Arrays.copyOfRange(items, 1, items.length));

        if (index == -1) {
            return -1;
        } else {
            return index + 1;
        }
        
    }
    
}
