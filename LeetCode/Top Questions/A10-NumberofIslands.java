/*
200. Number of Islands
*/

class Solution {
    public int numIslands(char[][] grid) {
        //No Shortest Path, Total number of Islands =>DFS Approach
        int numIslands =0;
        if(grid==null || grid.length==0 || grid[0].length==0) return numIslands;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j]=='1'){
                    dfsHelper(grid, i, j);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }

    public void dfsHelper(char[][] grid, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j]=='0') return;

        //visited land, mark as '0'
        grid[i][j] = '0';
        //recursively check all the lands we are able to reach
        dfsHelper(grid, i-1, j);
        dfsHelper(grid, i+1, j);
        dfsHelper(grid, i, j-1);
        dfsHelper(grid, i, j+1);
    }
}/*
DFS approach
Time Complexity: O(R*C)
Space Complexity: O(R*C)
*/
