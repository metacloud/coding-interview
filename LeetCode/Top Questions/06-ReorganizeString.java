/*
767. Reorganize String
*/

class Solution {
    public class charCnt {
        char ch;
        int cnt;
        charCnt(char ch, int cnt){
            this.ch = ch;
            this.cnt = cnt;
        }
    }

    public String reorganizeString(String S) {
        if(S==null || S.length()==0) return "";

        // Check all the characters frequncy
        int[] count = new int[26];
        for(char ch : S.toCharArray()) count[ch-'a']++;

        PriorityQueue<charCnt> pq = new PriorityQueue<>(new Comparator<charCnt>(){
           @Override
            public int compare(charCnt a, charCnt b){
                return (b.cnt-a.cnt!=0 ? b.cnt-a.cnt : a.ch-b.ch);
            }
        });

        //add all the chars in S to PriorityQueue
        for(int i=0; i<count.length; i++){
            if(count[i]>0) pq.offer(new charCnt((char)(i+'a'),count[i]));
        }


        StringBuilder sb = new StringBuilder();
        Queue<charCnt> queue = new LinkedList<>();
        while(!pq.isEmpty()){
            charCnt curr = pq.poll();
            sb.append(curr.ch);
            curr.cnt--;
            queue.offer(curr);

            if(queue.size()==2){ //k==2 in this problem
                charCnt temp = queue.poll();
                if(temp.cnt>0){
                    pq.offer(temp);
                }
            }
        }
        return sb.toString().length()==S.length() ? sb.toString() : "";
    }
}
