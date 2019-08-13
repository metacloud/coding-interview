/*
Min Cost to Repair Edges
*/

/*
There's an undirected connected graph with n nodes labeled 1..n. But some of the edges has been broken disconnecting the graph.
Find the minimum cost to repair the edges so that all the nodes are once again accessible from each other.

Example 1:
Input: n = 5, edges = [[1, 2], [2, 3], [3, 4], [4, 5], [1, 5]], edgesToRepair = [[1, 2, 12], [3, 4, 30], [1, 5, 8]]
Output: 20
Explanation:
There are 3 connected components due to broken edges: [1], [2, 3] and [4, 5].
We can connect these components into a single component by repearing the edges between nodes 1 and 2, and nodes 1 and 5 at a minimum cost 12 + 8 = 20.
*/

class Solution {
    public class Pair {
        List<Integer> nodes;
        int cost;
        Pair(List<Integer> nodes, int cost){
            this.nodes = nodes;
            this.cost = cost;
        }
    }

    public int minCostRepairEdges(int N, int[][] edges, int[][] edgesToRepair){

        //nodes pair , costs
        Map<List<Integer>, Integer> map = new HashMap<>();
        for(int[] edge : edges){
            map.put(Arrays.asList(edge[0], edge[1]), 0);
        }

        for(int[] repair : edgesToRepair){
            map.put(Arrays.asList(repair[0], repair[1]), repair[2]);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair a, Pair b){
                return a.cost-b.cost;
            }
        });

        for(List<Integer> nodes : map.keySet()){
            pq.offer(new Pair(nodes, map.get(nodes)));
        }


        int[] unionFind = new int[N+1];

        int cost=0, edgeCnt = 0;
        while(!pq.isEmpty()){
            Pair temp = pq.poll();
            int ua = find(unionFind, temp.nodes.get(0));
            int ub = find(unionFind, temp.nodes.get(1));

            if(ua != ub){
                unionFind[ua] = ub;
                cost += temp.cost;
                edgeCnt++;
            }
        }
        return (edgeCnt == N-1 ? cost : -1);
    }

    public int find(int[] uf, int find){
        if(uf[find]==0) return find;
        uf[find] = find(uf, uf[find]);
        return uf[find];
    }
}
