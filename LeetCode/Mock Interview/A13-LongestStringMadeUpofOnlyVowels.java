/*
Longest string made up of only vowels
*/

/*
You are given with a string . Your task is to remove atmost two substrings of any length from the given string such that the remaining string contains vowels('a','e','i','o','u') only. Your aim is the maximise the length of the remaining string. Output the length of remaining string after removal of atmost two substrings.
NOTE: The answer may be 0, i.e. removing the entire string.

input = earthproblem
output = 3

input = letsgosomewhere
output = 2

*/

class Solution {
    public int onlyVowels(String str){

        Set<Character> set = new HashSet<>();
        set.add('a'); set.add('e'); set.add('i'); set.add('o'); set.add('u');

        int start = 0;
        while(set.contains(str.charAt(start))) start++;

        int end = str.length()-1;
        while(set.contains(str.charAt(end))) end--;

        int max = 0;
        for(int i=start; i<end+1; i++){
            int contiguousCnt = 0;
            while(set.contains(str.charAt(i))){
                contiguousCnt++;
                i++;
            }
            max = Math.max(max, contiguousCnt);
        }
        return start+(str.length()-1-end)+max;
    }
}/*
Time Complexity: O(N)
Space Complexity: O(5) ~= O(1)
*/
