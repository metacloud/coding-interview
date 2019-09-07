/*
17. Letter Combinations of a Phone Number
*/


class Solution { //BFS
    public List<String> letterCombinations(String digits) {
        if(digits==null || digits.length()==0) return new ArrayList<>();
        String[] mapping ={ "0", "0", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

        LinkedList<String> queue = new LinkedList<>();
        queue.offer("");
        int i=0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int k=0; k<size; k++){
                String curr = queue.poll();
                for(char ch : mapping[digits.charAt(i)-'0'].toCharArray()){
                    queue.offer(curr+ch);
                }
            }
            i++;
            if(digits.length()==i) break;
        }
        return queue;
    }
}



class Solution { //DFS
    public List<String> letterCombinations(String digits){
        List<String> ret = new ArrayList<>();
        if(digits==null || digits.length()==0) return ret;

        String[] mapping = { "0", "0", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        dfsHelper(digits, 0, "", ret, mapping);
        return ret;
    }

    private void dfsHelper(String digits, int index, String curr, List<String> ret, String[] mapping){
        if(digits.length()==index){
            ret.add(curr);
            return;
        }
        for(char ch : mapping[digits.charAt(index)-'0'].toCharArray()){
            dfsHelper(digits, index+1, curr+ch, ret, mapping);
        }
    }
}
