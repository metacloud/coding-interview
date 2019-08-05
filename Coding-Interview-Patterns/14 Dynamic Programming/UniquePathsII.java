/*
63. Unique Paths II
*/

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1) return 0;

        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        obstacleGrid[0][0] = 1;

        // 1. Filling the values for the first colum
        for(int i=1; i<row; i++){
            if(obstacleGrid[i][0]==1 || obstacleGrid[i-1][0]==0){
                //if it has obstacle or prev-cell has obstacle
                obstacleGrid[i][0] = 0;
            } else {
                obstacleGrid[i][0] = 1;
            }
        }

        // 2. Filling the values for the first row
        for(int j=1; j<col; j++){
            if(obstacleGrid[0][j]==1 || obstacleGrid[0][j-1]==0){
                obstacleGrid[0][j] = 0;
            } else{
                obstacleGrid[0][j] = 1;
            }
        }

        // 3. Filling the values for the rest of the Grid
        for(int i=1; i<row; i++){
            for(int j=1; j<col; j++){
                if(obstacleGrid[i][j]==1){
                    obstacleGrid[i][j] = 0;
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                }
            }
        }
        return obstacleGrid[row-1][col-1];
    }
}
/*
Time Complexity: O(M×N)
Space Complexity: O(1) We are utilizing the obstacleGrid as the DP array. Hence, no extra space.
*/
