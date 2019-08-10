/*
695. Max Area of Island
*/

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea=0;
        if(grid==null || grid.length==0 || grid[0].length==0) return maxArea;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] != 1){
                    continue;
                }
                maxArea = Math.max(maxArea, dfsHelper(grid,i,j));
            }
        }
        return maxArea;
    }

    public int dfsHelper(int[][] grid, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j]==0) return 0;

        int areaCnt = 1;
        grid[i][j] = 0;
        areaCnt += dfsHelper(grid, i+1, j);
        areaCnt += dfsHelper(grid, i-1, j);
        areaCnt += dfsHelper(grid, i, j+1);
        areaCnt += dfsHelper(grid, i, j-1);

        return areaCnt;
    }
}/*
Time Complexity: O(R*C)
Space Complexity: O(R*C)
*/
