package dev.pia.weekfive;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class MissingNumber {

    // public static void main(String[] args) {
        
    //     int[] arr = { 2, 1, 4, 3, 6, 5, 7, 10, 9 };
    //     int maxNum = 10;

    //     int missingNumber = missingNumber(arr, maxNum);
    //     System.out.println("This is reduced runtime: " + missingNumber);
    // }
        

    public int missingNumber(int[] arr, int maxNum) {

        Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet());

        for (int i = 1; i <= maxNum; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return 0;
    }
    
}
