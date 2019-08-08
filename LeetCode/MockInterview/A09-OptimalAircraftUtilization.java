/*
Optimal Aircraft Utilization
*/

/*
Your task is to write an algorithm to optimize the sets of forward/return shipping route pairs that allow the aircraft to be optimally utilized, given a list a of forward routes and a list of return shipping routes.
*/

class Solution {
    public List<List<Integer>> optimalRoute(int maxTravelDist, List<List<Integer>> forwardRouteList, List<List<Integer>> returnRouteList){
        List<List<Integer>> ret = new ArrayList<>();

        //sort two Lists
        Collections.sort(forwardRouteList, new Comparator<List<Integer>>(){
            @Override
            public int compare(List<Integer> a, List<Integer> b){
                return a.get(1)-b.get(1);
            }
        });

        Collections.sort(returnRouteList, new Comparator<List<Integer>>(){
            @Override
            public int compare(List<Integer> a, List<Integer> b){
                return a.get(1)-b.get(1);
            }
        });

        List<Integer> path = new ArrayList<>();
        int i = 0, j = returnRouteList.size()-1;
        int max = 0;
        while(i < forwardRouteList.size() && j >= 0){
            int curr = forwardRouteList.get(i).get(1) + returnRouteList.get(j).get(1);

            if(curr == maxTravelDist){
                max = curr;
                ret.add(new ArrayList<>(Arrays.asList(forwardRouteList.get(i).get(0), returnRouteList.get(j).get(0))));
                i++;
            }
            else if(curr < maxTravelDist){
                if(curr > max){
                    max = curr;
                    path.clear();
                    path.add(forwardRouteList.get(i).get(0));
                    path.add(returnRouteList.get(j).get(0));
                }
                i++;
            }
            else { // curr > maxTravelDist
                j--;
            }
        }
        if(ret.size()==0) ret.add(new ArrayList<>(path));

        return ret;
    }
}
