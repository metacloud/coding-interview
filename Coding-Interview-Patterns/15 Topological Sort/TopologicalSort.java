
/*
Pattern: Topological Sort
01 Topological Sort (medium)

Topological Sort of a directed graph (a graph with unidirectional edges) is a linear ordering of its vertices
such that for every directed edge (U, V) from vertex U to vertex V, U comes before V in the ordering.
Given a directed graph, find the topological ordering of its vertices.

Input: Vertices=4, Edges=[3, 2], [3, 0], [2, 0], [2, 1]
Output: Following are the two valid topological sorts for the given graph:
1) 3, 2, 0, 1
2) 3, 2, 1, 0
*/

import java.util.*;

class TopologicalSort {
    public static List<Integer> sort(int vertices, int[][] edges){
      List<Integer> topologicalOrder = new ArrayList<>();
      if(vertices <= 0) return topologicalOrder;

      // (parent vertices, List containing children vertices)
      HashMap<Integer, List<Integer>> graph = new HashMap<>();
      //count of incoming edges for every vertex : (vertex, nums of incoming edges)
      HashMap<Integer, Integer> inDegree = new HashMap<>();



      // 1. Initialize the graph
      for(int i=0; i<vertices; i++){
        inDegree.put(i,0);
        graph.put(i, new ArrayList<Integer>());
      }

      // 2. Build the graph
      for(int i=0; i<edges.length; i++){
        int parent = edges[i][0];
        int child = edges[i][1];

        graph.get(parent).add(child);
        inDegree.put(child, inDegree.get(child)+1);
      }

      // 3. Find all sources whilch has 0 incoming edge.
      Queue<Integer> sources = new LinkedList<>();
      for(Map.Entry<Integer, Integer> entry: inDegree.entrySet()){
        if(entry.getValue() == 0) sources.add(entry.getKey());
      }

      /* 4. Add each source to the topologicalOrder,
         and subtract one from all of its children's in-degrees.
         if a child's in-degree = 0, then add it to the sources. and repeat. */
      while(!sources.isEmpty()){
        int vertex = sources.poll();
        topologicalOrder.add(vertex);

        List<Integer> children = graph.get(vertex);
        for(int child : children){
          inDegree.put(child, inDegree.get(child)-1);
          if(inDegree.get(child)==0) sources.add(child);
        }
      }

      //it means the graph has a cycle => topological order is not possible.
      if(topologicalOrder.size() != vertices){
        return new ArrayList<>();
      }

      return topologicalOrder;
    }/*
    Time Complexity: O(V+E)
    Space Complexity: O(V+E)
    */

    public static void main(String[] args) {
        List<Integer> result = TopologicalSort.sort(4,
            new int[][] { new int[] {3, 2}, new int[] {3, 0}, new int[] {2, 0}, new int[] {2, 1} });
        System.out.println(result);

        result = TopologicalSort.sort(5, new int[][] { new int[] {4, 2}, new int[] {4, 3}, new int[] {2, 0},
            new int[] {2, 1}, new int[] {3, 1} });
        System.out.println(result);

        result = TopologicalSort.sort(7, new int[][] { new int[] {6, 4}, new int[] {6, 2}, new int[] {5, 3},
            new int[] {5, 4}, new int[] {3, 0}, new int[] {3, 1}, new int[] {3, 2}, new int[] {4, 1} });
        System.out.println(result);
  }
}
