/*
LeetCode 771. Jewels and Stones

[Result]
Runtime: 2 ms, faster than 28.69% of Java online submissions for Jewels and Stones.
Memory Usage: 34.6 MB, less than 99.82% of Java online submissions for Jewels and Stones.
*/


class Solution {
    public int numJewelsInStones(String J, String S){
        Set<Character> set = new HashSet<Character>();
        for(char j: J.toCharArray()){
            set.add(j);
        }
        int total=0;
        for(char s: S.toCharArray()){
            if(set.contains(s)){
                total++;
            }
        }
        return total;
    }
}