/*
207. Course Schedule
*/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] indegree = new int[numCourses];
        List<List<Integer>> outdegree = new ArrayList<>();
        for(int i=0; i<numCourses; i++) outdegree.add(new ArrayList<Integer>());

        for(int[] edge : prerequisites){
            indegree[edge[0]]++;
            outdegree.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0) queue.offer(i);
        }

        Set<Integer> visited = new HashSet<>();
        while(!queue.isEmpty()){
            int curr = queue.poll();
            visited.add(curr);
            for(int node : outdegree.get(curr)){
                if(--indegree[node]==0) queue.offer(node);
            }
            outdegree.get(curr).clear();
        }
        return visited.size()==numCourses;
    }
}
