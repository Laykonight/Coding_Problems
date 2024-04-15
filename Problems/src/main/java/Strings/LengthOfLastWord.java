package Strings;

/*
Given a string s consisting of words and spaces, return the length of the last word in the string.
A word is a maximal substring consisting of non-space characters only.

Example 1:
Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.

Example 2:
Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.

Example 3:
Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.
*/

public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        StringBuilder str = new StringBuilder(s);
        int count = 1;

        while (str.charAt(str.length()-1) == ' '){
            str.deleteCharAt(str.length()-1);
        }
        StringBuilder lastWord = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ') {
                lastWord.append(str.substring(i + 1));
                break;
            }
            if (i == 0){
                return str.length();
            }
        }
        return lastWord.length();
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
    }
}
