package Arrays;

/*
Given an array of distinct integers,
print all the pairs having positive value and negative value of a number that exists in the array.
The pairs can be printed in any order.

Examples:
Input: arr[] = { 1, -3, 2, 3, 6, -1 }
Output: -1 1 -3 3
*/

import java.util.HashMap;

public class FindAllPositiveAndNegativePairs {
    public static void FindPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            if (map.containsKey(num)){
                System.out.println(num + " " + -num);
                map.remove(num);
                continue;
            }
            map.put(-num, num);
        }
        map.clear();
    }

    public static void main(String[] args) {
        int [] arr = {1,-3,2,3,6,-1};
        FindPairs(arr);
    }
}
