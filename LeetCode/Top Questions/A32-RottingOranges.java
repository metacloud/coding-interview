/*
994. Rotting Oranges
*/

class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0) return 0;

        int fresh=0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j]==2) {
                    queue.offer(new int[] {i, j});
                }
                else if(grid[i][j]==1) fresh++;
            }
        }

        if(fresh==0) return 0;

        int[][] dirs = { {-1,0}, {1,0}, {0,-1}, {0,1} };
        int min=0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int[] temp = queue.poll();
                for(int[] dir : dirs){
                    int nr = temp[0] + dir[0];
                    int nc = temp[1] + dir[1];
                    if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length &&
                      grid[nr][nc]==1){
                        fresh--;
                        queue.offer(new int[] {nr, nc});
                        grid[nr][nc]=2;
                    }
                }
            }
            if(queue.isEmpty()) break;
            min++;
        }
        return fresh==0 ? min : -1;
    }
}
