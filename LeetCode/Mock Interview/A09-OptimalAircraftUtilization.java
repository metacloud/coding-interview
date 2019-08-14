/*
Optimal Aircraft Utilization
*/

/*
Your task is to write an algorithm to optimize the sets of forward/return shipping route pairs that allow the aircraft to be optimally utilized, given a list a of forward routes and a list of return shipping routes.
*/

class Solution {
    public static List<List<Integer>> aircraftUtilization(int maxTravelDist, int[][] forwardRouteList, int[][] returnRouteList){
        if(maxTravelDist==0 || forwardRouteList==null || forwardRouteList.length==0 || returnRouteList==null || returnRouteList.length==0) return null;

        //Arrays.sort(forwardRouteList, (int[] a, int[] b) -> (a[1] - b[1]));
        Arrays.sort(forwardRouteList, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){ return a[1]-b[1]; }
        });

        Arrays.sort(returnRouteList, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){ return a[1]-b[1]; }
        });

        int left = 0, right = returnRouteList.length-1;
        int max = Integer.MIN_VALUE;
        Map<Integer, List<List<Integer>>> map = new HashMap<>();

        while(left<forwardRouteList.length && right>=0){
            int sum = forwardRouteList[left][1] + returnRouteList[right][1];

            if(sum > maxTravelDist){
                right--;
            }
            else if(sum <= maxTravelDist){
                if(sum >= max){
                    max = sum;
                    map.putIfAbsent(sum, new ArrayList<>());
                    int duplicateCheck = right;

                    while(duplicateCheck >=0 && returnRouteList[duplicateCheck][1]==returnRouteList[right][1]){
                        List<Integer> pair = new ArrayList<>();
                        pair.add(forwardRouteList[left][0]); pair.add(returnRouteList[duplicateCheck][0]);
                        map.get(sum).add(pair);
                        duplicateCheck--;
                    }
                }
                left++;
            }
        }
        return map.get(max);
    }
}
