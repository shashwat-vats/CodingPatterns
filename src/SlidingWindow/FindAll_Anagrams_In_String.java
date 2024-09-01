package SlidingWindow;

import java.util.ArrayList;
import java.util.List;

public class FindAll_Anagrams_In_String {

    /*
    * LeetCode:438
    * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

       An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
       Example 1:

       Input: s = "cbaebabacd", p = "abc"
       Output: [0,6]
       Explanation:
       The substring with start index = 0 is "cba", which is an anagram of "abc".
       The substring with start index = 6 is "bac", which is an anagram of "abc".
    *
    * */

    static boolean checkAnagrams(String s, String p) {
        int sSize = s.length();
        int[] arr = new int[26];
        for(int i = 0; i<sSize ; i++) {
            arr[s.charAt(i) - 'a']++;
            arr[p.charAt(i) - 'a']--;
        }
        for (int j : arr) {
            if (j != 0) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        int pSize =  p.length();
        int sSize = s.length();
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < sSize - pSize +1 ; i++) {
            if(checkAnagrams(s.substring(i, i+pSize),p)) {
                result.add(i);
            }
        }
        System.out.println(result);
    }
}
