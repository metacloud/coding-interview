/*
Shortest Path From Multiple Sources
*/

/*
Given: 2D Matrix
Multiple Starting Points 'S', Multiple End Points 'E' and dead blocks 'D' and '1's you can walk through.
We can start from any 'S' point and can end at any 'E' point.
Find the shortest distance from any starting point to any end point.
*/

class Solution { // BFS - shortest path
    	public static int minDist(char[][] grid){
		if(grid==null || grid.length==0 || grid[0].length==0) return -1;

		int minSteps = Integer.MAX_VALUE;
		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[i].length; j++){
				if(grid[i][j]=='S'){
					boolean[][] visited = new boolean[grid.length][grid[0].length];
					int steps = bfsHelper(grid, i, j, visited);
					minSteps = Math.min(minSteps, steps);
				}
			}
		}
		return minSteps;
	}

	public static int bfsHelper(char[][] grid, int i, int j, boolean[][] visited){
		if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] != 'S' && visited[i][j]==true) return -1;

		int step=0;

		int[][] dirs = { {-1,0}, {1,0}, {0,-1}, {0,1} };
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{i, j});

		visited[i][j] = true;
		while(!queue.isEmpty()){
			int size = queue.size();
			for(int k=0; k<size; k++){
				int[] curr = queue.poll();

				for(int[] dir : dirs){
					int nr = curr[0]+dir[0];
					int nc = curr[1]+dir[1];

					if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length &&
						grid[nr][nc]!='D' && visited[nr][nc]==false){
						if(grid[nr][nc]=='E') return step+1;
						queue.offer(new int[] {nr, nc});
						visited[nr][nc]=true;
					}
				}
			}
			step++;
		}
		return -1; //no path to end point
	}
}
