/*
1135. Connecting Cities With Minimum Cost
*/

class Solution {
    public int minimumCost(int N, int[][] connections) {

        int[] unionFind = new int[N+1];
        Arrays.sort(connections, new Comparator<int[]>(){
           @Override
            public int compare(int[] a, int[] b){
                return a[2]-b[2];
            }
        });

        int sum=0, edge=0;
        for(int[] i : connections){
            int ua = find(unionFind, i[0]); //node1
            int ub = find(unionFind, i[1]); //node2

            if(ua != ub){
                unionFind[ua] = ub;
                sum+= i[2];
                edge++;
            }
        }
        return edge == N-1 ? sum : -1;
    }

    public int find(int[] uf, int find){
        if(uf[find]==0) return find;
        uf[find] = find(uf, uf[find]);
        return uf[find];
    }
}
