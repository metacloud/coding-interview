/*
Longest string made up of only vowels
*/

/*
You are given with a string . Your task is to remove atmost two substrings of any length from the given string such that the remaining string contains vowels('a','e','i','o','u') only. Your aim is the maximise the length of the remaining string. Output the length of remaining string after removal of atmost two substrings.
NOTE: The answer may be 0, i.e. removing the entire string.

*/

class Solution {
    public int onlyVowels(String str){
        char[] arr = str.toCharArray();
        int start = 0;
        int end = str.length()-1;

        Set<Character> set = new HashSet<>();
        set.add('a'); set.add('e'); set.add('i'); set.add('o'); set.add('u');

        while(set.contains(arr[start])) start++;
        while(set.contains(arr[end])) end--;

        int max = Integer.MIN_VALUE;
        for(int i=start; i<end+1; i++){
            int contiguousCnt = 0;
            while(set.contains(arr[i])){
                contiguousCnt++;
                i++;
            }
            max = Math.max(max, contiguousCnt);
        }
        return start+(str.length()-1-end)+max;
    }
}
