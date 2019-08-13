/*
03. Longest Substring Without Repeating Characters


159. Longest Substring with At Most Two Distinct Characters
340. Longest Substring with At Most K Distinct Characters
992. Subarrays with K Different Integers
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        if(s==null || s.length()==0) return max;

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
