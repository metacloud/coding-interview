/*
78. Subsets
*/


class Solution { //BFS
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if(nums==null || nums.length==0) return ret;
        ret.add(new ArrayList<>());

        for(int num : nums){
            int size = ret.size(); //like queue
            for(int i=0; i<size; i++){
                List<Integer> set = new ArrayList<>(ret.get(i));
                set.add(num);
                ret.add(set);
            }
        }
        return ret;
    }
}


class Solution { // DFS
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> subsets = new ArrayList<>();
        if(nums==null || nums.length==0) return subsets;

        dfsHelper(nums, 0, new ArrayList<Integer>(), subsets);
        return subsets;
    }

    private void dfsHelper(int[] nums, int index, List<Integer> curr, List<List<Integer>> subsets){
        subsets.add(new ArrayList<>(curr));
        for(int i=index; i<nums.length; i++){
            curr.add(nums[i]);
            dfsHelper(nums, i+1, curr, subsets);
            curr.remove(curr.size()-1); //backtracking
        }
    }
}
