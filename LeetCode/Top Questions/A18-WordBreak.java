/*
139. Word Break
*/

class Solution {
    public boolean wordBreak(String s, List<String> wordDict){
        boolean[] dp = new boolean[s.length()+1];
        Set<String> set = new HashSet<>(wordDict);

        dp[0] = true;
        for(int i=1; i<=s.length(); i++){
            for(int j=0; j<i; j++){
                if(dp[j]==true && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}/*
Time Complexity: O(N^2)
Space Complexity: O(N+M) where N is the length of String s, M is the number of wordDict
*/
