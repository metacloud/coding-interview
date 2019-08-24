/*
49. Group Anagrams
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> groupAnagrams = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(String curr : strs){
            char[] chars = curr.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);

            if(!map.containsKey(sortedStr)){
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(curr);
        }

        groupAnagrams.addAll(map.values());
        return groupAnagrams;
    }
}/*
Time Complexity: O(N*KlogK)
where N is the length of strs, K is the max length of a string in strs.
The outer loop has complexity O(N) as we iterate through each string. Then we sort each string in O(KlogK) time.

Space Complexity: O(N)
*/
