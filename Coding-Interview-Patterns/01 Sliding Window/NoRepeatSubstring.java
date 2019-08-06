/*
Pattern: Sliding Window
05 No-repeat Substring (hard)

Given a string, find the length of the longest substring which has no repeating characters.

Input: String="aabccbb"
Output: 3
Explanation: The longest substring without any repeating characters is "abc".

# LeetCode 3. Longest Substring Without Repeating Characters
Runtime: 7 ms, faster than 82.46% of Java online submissions for Longest Substring Without Repeating Characters.
Memory Usage: 35.9 MB, less than 99.92% of Java online submissions for Longest Substring Without Repeating Characters.
[Result]
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        if(s==null || s.length()==0) return max;
        
        // <character - index >
        Map<Character, Integer> map = new HashMap<>();
        
        int start=0;
        for(int end=0; end<s.length(); end++){
            
            char added = s.charAt(end);
            if(map.containsKey(added)){ // b a d e a b 
                start = Math.max(map.get(added)+1, start);
            }

            map.put(added, end);
            int len = end - start +1;
            max = Math.max(max, len);
        }
        return max;
    }
}