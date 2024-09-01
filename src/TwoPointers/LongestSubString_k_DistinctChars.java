package TwoPointers;

import java.util.HashMap;
import java.util.Map;

public class LongestSubString_k_DistinctChars {
    //Combo: two pointer and Sliding Window
  /*
        340:longest-substring-with-at-most-k-distinct-characters
        * Given a string s and an integer k,
        return the length of the longest substring of s that contains at most k distinct characters.

        Example 1:

        Input: s = "eceba", k = 2
        Output: 3
        Explanation: The substring is "ece" with length 3.
        Example 2:

        Input: s = "aa", k = 1
        Output: 2
        Explanation: The substring is "aa" with length 2.


        Constraints:

        1 <= s.length <= 5 * 104
        0 <= k <= 50
       */


    public static int maxLength(String s, int k) {
        int maxLength = 0;
        int l = 0;
        int r = 0;
        char[] crr = s.toCharArray();
        int n = crr.length;
        Map<Character, Integer> charMap = new HashMap<>();
        while(r<n) {
            charMap.put(crr[r],r+1);
            int charFreq = charMap.get(crr[r]);
            if(charMap.size()>k) {
                charMap.put(crr[r],charFreq-1);
                if(charMap.get(crr[r])==0) {
                    charMap.remove(crr[r]);
                }
                l = l+1;
            }
            if(charMap.size()<=k) {
                maxLength = Math.max(maxLength, r - l + 1);
            }
            r=r+1;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "aaabbccd";
        int k = 2;
        System.out.println(maxLength(s,k));
    }
}
