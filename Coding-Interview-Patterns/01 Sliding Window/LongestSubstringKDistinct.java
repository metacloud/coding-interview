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

class LongestSubstringKDistinct {
  public static int findLength(String str, int k) {
    if(str==null || str.length()==0 || str.length()<k)
      throw new IllegalArgumentException();

    Map<Character, Integer> hashmap = new HashMap<>();

    int LongestSub = 0;
    int start = 0;
    for(int end = 0; end < str.length(); end++) {

        char added = str.charAt(end);
        hashmap.put(added, hashmap.getOrDefault(added,0) +1);

        while(hashmap.size()>k){
          char removed = str.charAt(start);
          hashmap.put(removed, hashmap.get(removed)-1);
          if(hashmap.get(removed) == 0) hashmap.remove(removed);
          start++;
        }

        int currLen = end - start + 1;
        LongestSub = Math.max(LongestSub, currLen);
    }

    return LongestSub;
  }/*
  Time Complexity: O(N)
  Space Complexity: O(K) where K is the number of distinct characters
  */
}
