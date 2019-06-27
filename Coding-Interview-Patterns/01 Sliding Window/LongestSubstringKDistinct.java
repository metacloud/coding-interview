/*
Pattern: Sliding Window
03 Longest Substring with K Distinct Characters (medium)

Given a string,
find the length of the longest substring in it with no more than K distinct characters.

[Example]
Input: String="araaci", K=2
Output: 4
Explanation: The longest substring with no more than '2' distinct characters is "araa".

*/

import java.util.*;

class LongestSubstringKDistinct {
  public static int findLength(String str, int k) {

    HashMap<Character, Integer> hashmap = new HashMap<>();

    int start = 0, end = 0;
    int currLen = 0, LongestSub = 0;

    for(end = 0; end < str.length(); end++) {

        char added = str.charAt(end);
        hashmap.put(added, hashmap.getOrDefault(added,0) +1);

        while(hashmap.size()>k){
          char removed = str.charAt(start);
          hashmap.put(removed, hashmap.get(removed)-1);
          if(hashmap.get(removed) == 0) hashmap.remove(removed);
          start++;
        }

        currLen = end - start + 1;
        LongestSub = Math.max(LongestSub, currLen);
    }

    return LongestSub;
  }/*
  Time Complexity: O(N)
  Space Complexity: O(K) where K is the number of distinct characters
  */

  public static void main(String[] args) {
    System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
    System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
    System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
  }
}
