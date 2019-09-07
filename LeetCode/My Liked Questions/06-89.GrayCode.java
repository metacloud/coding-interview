/*
89. Gray Code
*/

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<>();
        ret.add(0);
        if(n==0) return ret;
        ret.add(1); // ret={0,1} for n==1

        int curr=1;
        for(int i=2; i<=n; i++){
            curr = curr*2;
            int size = ret.size();
            for(int j=size-1; j>=0; j--){
                ret.add(ret.get(j)+curr);
            }
        }
        return ret;
    }
}
