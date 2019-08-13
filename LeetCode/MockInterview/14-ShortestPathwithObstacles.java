/*
Shortest Path with Obstacles

https://leetcode.com/discuss/interview-question/301192/Facebook-phone-screen-Shortest-Path-with-Obstacles/283312

Given a 2D matrix where some of the elements are filled with 1 and the rest of the elements are filled with X,
except 2 elements, of which one is S (start point) and E (endpoint).
Here X means you cannot traverse to that particular point.
From a cell you can either traverse to left, right, up or down.

Given two points in the matrix find the shortest path between these points.
For example, if the matrix is
1 1 1 1 1
S 1 X 1 1
1 1 1 1 1
X 1 1 E 1
1 1 1 1 X

One of the shortest paths (from E to S both exclusive) is:
[(3, 2), (3, 1), (2, 1), (2, 0)]. Return null if there is no path between S and E.
*/

class Solution {
    private static int start = -1, end = -1;

    public static List<int[]> shortestPath(char[][] grid) {
        intk m = grid.length;
        int n = grid[0].length;
        List<int[]> path = new ArrayList<>();

        for (int i=0; i < m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 'S') {
                    //convert 2d index to 1d to store parent child mapping
                    start = i + n * j;
                    bfs(grid, i, j);
                    break;
                }
            }
        }

        if (start != -1 && end != -1) {
            path.add(new int[]{end % n, end /n});
            int parent  = parentMap.get(end);
            while(parent != start) {
                path.add(new int[]{parent % n, parent /n});
                parent = parentMap.get(parent);
            }

            path.add(new int[]{start%n, start/n});
            Collections.reverse(path);
        } else {
            System.out.println("No path");
        }

        return path;

    }

    private static int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1, 0}};
    private static HashMap<Integer, Integer> parentMap = new HashMap<>();


    private static void bfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        queue.offer(new int[]{i, j});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir : dirs) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];

                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || grid[x][y] == 'X') {
                    continue;
                }

                int parent = curr[0] + n * curr[1];
                int child = x + n * y;

                if (grid[x][y] == 'E') {
                    end = child;
                    parentMap.put(child, parent);
                    return;
                }

                visited[x][y] = true;
                int[] next = new int[]{x, y};
                parentMap.put(child, parent);
                queue.offer(next);

            }
        }
    }

    public static void main(String[] args) {
        Test obj = new Test();
        char[][] grid = {{'1', '1', 'X', '1', '1'},
                {'S', '1', 'X', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'X', '1', '1', 'E', '1'},
                {'1', '1', '1', '1', 'X'}};

        List<int[]> path = shortestPath(grid);
        System.out.println("Path length:" + (path.size() - 1));
        path.stream().forEach(i -> {
            System.out.println("{" + i[0] + "," + i[1] + "}");
        });

    }
}
