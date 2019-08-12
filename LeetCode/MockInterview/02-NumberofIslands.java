/*
200. Number of Islands
*/

class Solution {
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        if(grid==null || grid.length==0 || grid[0].length==0) return numIslands;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j]!='1'){
                    continue;
                }
                numIslands++;
                dfsHelper(grid, i, j);
            }
        }
        return numIslands;
    }

    public void dfsHelper(char[][] grid, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j] != '1') return;

        grid[i][j] = '0';
        dfsHelper(grid, i+1, j);
        dfsHelper(grid, i-1, j);
        dfsHelper(grid, i, j+1);
        dfsHelper(grid, i, j-1);
    }
}/*
Time Complexity: O(R*C)
Space Complexity: O(R*C)
*/
