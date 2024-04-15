package Arrays;

/*
Given an integer array nums of length n where all the integers of nums are in the range [1, n]
and each integer appears once or twice, return an array of all the integers that appears twice.
You must write an algorithm that runs in O(n) time and uses only constant extra space.

Example 1:
Input: nums = [4,3,2,7,8,2,3,1]
Output: [2,3]

Example 2:
Input: nums = [1,1,2]
Output: [1]

Example 3:
Input: nums = [1]
Output: []

*/

import java.util.HashMap;
import java.util.HashSet;

public class FindAllDuplicates {
    public static void findDuplications(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num) && map.get(num) == 0) {
                System.out.println(num);
                map.put(num, map.get(num) + 1);
                continue;
            }
            map.put(num, 0);
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1,2};
        findDuplications(nums);
    }
}
