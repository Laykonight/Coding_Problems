package Arrays;

/*
Given an array, print the Next Greater Element (NGE) for every element.
The Next greater Element for an element x is the first greater element on the right side of x in the array.
Elements for which no greater element exists, consider the next greater element as -1.

Examples:
For an array, the rightmost element always has the next greater element as -1.
For an array that is sorted in decreasing order, all elements have the next greater element as -1.
For the input array [4, 5, 2, 25], the next greater elements for each element are as follows.
Element       NGE
   4      -->   5
   5      -->   25
   2      -->   25
   25     -->   -1
*/

import java.util.Arrays;
import java.util.PriorityQueue;

public class NextGreaterElement {
    public static int[] nextGreaterElement(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int [] result = new int[nums.length];
        int currentGreatest = nums[0];

        for (int num : nums){
            if (num > currentGreatest){
                pq.add(num);
                currentGreatest = num;
            }
        }

        if (!pq.isEmpty()){
            currentGreatest = pq.poll();
        }
        for (int i = 0; i < nums.length; i++){
            if (!pq.isEmpty()){
                if (nums[i] >= currentGreatest){
                    currentGreatest = pq.poll();
                }
                result[i] = currentGreatest;
                continue;
            }
            result[i] = -1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,2,7,25};

        System.out.println(Arrays.toString(nextGreaterElement(nums)));
    }
}
