/*
62. Unique Paths

[DP Similar questions]
91. Decode Ways
70. Climbing Stairs
509. Fibonacci Number
*/

// In problem, the rows treated as columns
// Time Complexity: O(N*M) , Space Complexity: O(N*M)

class Solution { // Bottom-Up DP
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i==0 || j==0){
                    grid[i][j] = 1;
                }
                else {
                    grid[i][j] = grid[i-1][j] + grid[i][j-1];
                }
            }
        }
        return grid[n-1][m-1];
    }
}


class Solution { // Top-Down
  public int uniquePaths(int m, int n){
    return pathHelper(m-1, n-1, new int[n][m]);
  }

  private int pathHelper(int m, int n, int[][] memo){
    if(m < 0 || n < 0) return 0;
    else if(m==0 || n==0) return 1;
    else if(memo[n][m] > 0) return memo[n][m];
    else {
      memo[n][m] = pathHelper(m-1, n, memo) + pathHelper(m, n-1, memo);
      return memo[n][m];
    }
  }
}
