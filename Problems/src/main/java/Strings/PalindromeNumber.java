package Strings;

/*
Given an integer x, return true if x is a palindrome, and false otherwise.

Example 1:
Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.

Example 2:
Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore, it is not a palindrome.

Example 3:
Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore, it is not a palindrome.
*/

public class PalindromeNumber {
    public static boolean isPalindrome(int n) {
        StringBuilder str = new StringBuilder(Integer.toString(n));
        String str1 = Integer.toString(n);
        String str2 = new String(str.reverse());

        return str1.equals(str2);
    }

    public static void main(String[] args) {
        int x = 1230321;
        System.out.println(isPalindrome(x));
    }
}
