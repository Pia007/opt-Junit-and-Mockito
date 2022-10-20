import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class MissingNumber {

    /*
        Imagine a list of numbers from 1 to max_num, inclusive - except that one of
        these numbers will be missing from the list.
        
        Write a function that takes this list of numbers, as well as the max_num, and
        it should return the missing number.
        
        For example, given a list of numbers, in random order, of 1…10, 8 was
        removed. If this list and the maxNum of 10 was passed into the function, it
        would return 8: missingNumber({2, 1, 4, 3, 6, 5, 7, 10, 9}, 10) ⇒ 8
        
        If there is no missing number, the function should return 0.

     */



    public static void main(String[] args) throws Exception {

        int[] arr = { 2, 1, 4, 3, 6, 5, 7, 10, 9 };
        int maxNum = 10;

        int missingNumber = missingNumber(arr, maxNum);
        System.out.println("This is reduced runtime: "  + missingNumber);

        int missingNumber2 = missingNumber2(arr, maxNum);
        System.out.println("This is reduced memory: " + missingNumber2);

        int missingNumber3 = missingNumber3(arr, maxNum);
        System.out.println("This is reduced runtime and memory: " + missingNumber3);
    }


    /*
     * 1. Reduce Runtime: Initially, focus on reducing runtime—this should be
        solvable in O(n) time.
        You can create an additional data structure using a Java library if
        necessary.
        
        Write a version that uses a straightforward solution and runs in O(n) time.
     
     */

    public static int missingNumber(int[] arr, int maxNum) {
        
        Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet());

        for (int i = 1; i <= maxNum; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return 0;
    }

    /*
     * 2. Reduce Memory: Now, think about reducing memory use—did your first
        solution require you to create a new object? Can you think of a different way
        to think about the problem that doesn’t use additional memory, even if it
        takes more time?
        
        There’s a way you could solve this in O(n log n) time that doesn’t require
        creating another large data structure (technically, while being O(n log n) in
        runtime, it is O(1) in “runspace”—it uses the same amount of memory no matter
        how big n is).
     */
    public static int missingNumber2(int[] arr, int maxNum) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }
        return 0;
    }

    /*
     * 3. There’s a solution that has O(n) runtime and O(1) runspace, but it requires a
        bit of creative thinking about the problem from a math perspective. See if
        you can find it.
     */

    public static int missingNumber3(int[] arr, int maxNum) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return (maxNum * (maxNum + 1) / 2) - sum;

    }

}
