/*
200. Number of Islands
*/

class Solution {
    public int numIslands(char[][] grid) {
        int numIslands=0;  
        if(grid==null || grid.length==0 || grid[0].length==0) return numIslands;
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length;j++){
                if(grid[i][j] != '1'){
                    continue;
                }
                numIslands++;
                DFS(grid, i, j);
            }
        }
        return numIslands;
    }
    
    public void DFS(char[][] grid, int i, int j){
        grid[i][j] = 'A';

        //top
        if(i-1 >= 0 && grid[i-1][j]=='1') DFS(grid, i-1, j);
        //bottom
        if(i+1 < grid.length && grid[i+1][j]=='1') DFS(grid, i+1, j);        
        //right
        if(j+1 < grid[i].length && grid[i][j+1]=='1') DFS(grid, i, j+1);
        //left
        if(j-1 >= 0 && grid[i][j-1]=='1') DFS(grid, i, j-1);
    }
}