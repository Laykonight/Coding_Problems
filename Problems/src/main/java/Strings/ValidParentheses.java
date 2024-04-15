package Strings;

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
determine if the input string is valid.
An input string is valid if:
1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.
3. Every close bracket has a corresponding open bracket of the same type.

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false
*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class ValidParentheses {
    public static boolean isParenthesesValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> open = new HashSet<>();
        open.add('(');
        open.add('[');
        open.add('{');
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        StringBuilder str = new StringBuilder(s);
        for (int i = 0; i < str.length(); i++) {
            if (open.contains(str.charAt(i))) {
                stack.push(str.charAt(i));
                continue;
            }
            if (map.containsKey(str.charAt(i))) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (map.get(str.charAt(i)) != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String falseStr = "{9+4-[1+5-(12+5)]}(";
        String trueStr = "{9+4-[1+5-(12+5)]}";
        System.out.println("falseStr: " + isParenthesesValid(falseStr));
        System.out.println("trueStr: " + isParenthesesValid(trueStr));
    }
}
