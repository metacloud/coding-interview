/*
Treasure Island
*/

/*
Input:
[['O', 'O', 'O', 'O'],
 ['D', 'O', 'D', 'O'],
 ['O', 'O', 'O', 'O'],
 ['X', 'D', 'D', 'O']]

Output: 5
Explanation: Route is (0, 0), (0, 1), (1, 1), (2, 1), (2, 0), (3, 0) The minimum route takes 5 steps.
*/

class Solution {
    public class Point {
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int minSteps(char[][] grid){
        int steps=0;
        if(grid==null || grid.length==0 || grid[0].length==0) return steps;
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[0][0] = true;
        
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0,0));
        
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        while(!queue.isEmpty()){    
            int size = queue.size();
            for(int i=0; i<size; i++){
                Point temp = queue.poll();
                int x = temp.x;
                int y = temp.y; 
                if(grid[x][y] == 'X') return steps;
                
                for(int[]  dir : dirs){
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    
                    if(nx >= 0 && nx < grid.length && ny>=0 && ny < grid[0].length && 
                      grid[nx][ny] != 'D' && visited[nx][ny] == false){
                        queue.offer(new Point(nx,ny));
                        visited[nx][ny] = true;
                    }
                }
            }
            steps++;
        }
        return 0; // no Treasure Island
    }
}/*
Time Complexity: O(M*N) 
Space Complexity: O(M*N)
*/
