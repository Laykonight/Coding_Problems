package Strings;

import java.util.LinkedHashMap;

/*
Print all distinct characters of a string in order

Given a string, find the all distinct (or non-repeating characters) in it.
For example, if the input string is “Geeks for Geeks”, then output should be ‘for’ and if input string is “Geeks Quiz”,
then output should be ‘Gks Quiz’.
The distinct characters should be printed in same order as they appear in input string.

Examples:
Input  : Geeks for Geeks
Output : for

Input  : Hello Geeks
Output : Ho Gks
*/
public class AllDistinctCharacters {
    public static void printAllDistinctCharacters(String str) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
                continue;
            }
            map.put(temp, 1);
        }

        map.forEach((k, v) ->{
           if (v == 1){
               result.append(k);
           }
        });
        System.out.println(result);
    }

    public static void main(String[] args) {
        String str = "Hello Geeks";
        printAllDistinctCharacters(str);
    }
}
