/*
242. Valid Anagram
*/

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] count = new int[26];
        for(char ch1 : s.toCharArray()){
            count[ch1-'a']++;
        }

        for(char ch2 : t.toCharArray()){
            count[ch2-'a']--;
            if(count[ch2-'a'] < 0) return false;
        }
        return true;
    }
}
