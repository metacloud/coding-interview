/*
358. Rearrange String k Distance Apart

Given a string and a number ‘K’, find if the string can be rearranged such that the same characters are at least ‘K’ distance apart from each other.
*/

class Solution {
    public class Pair {
        char ch;
        int cnt;
        Pair(char ch, int cnt){
            this.ch = ch;
            this.cnt = cnt;
        }
    }

    public String rearrangeString(String str, int k){
        //base check
        if(str==null || str.length()==0) return "";
        if(k<=1) return str;

        //check all chars frequency
        int[] count = new int[26];
        for(char ch : str.toCharArray()) count[ch-'a']++;

        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair a, Pair b){
                return b.cnt-a.cnt != 0 ? b.cnt-a.cnt : a.ch-b.ch;
            }
        });

        //add all to pq
        for(int i=0; i<count.length; i++){
            if(count[i]>0) pq.offer(new Pair((char)(i+'a'), count[i]));
        }

        StringBuilder sb = new StringBuilder();
        Queue<Pair> queue = new LinkedList<>();

        while(!pq.isEmpty()){
            Pair temp = pq.poll();
            sb.append(temp.ch);
            temp.cnt--;
            queue.offer(temp);

            if(queue.size()==k){
                Pair tmp = queue.poll();
                if(tmp.cnt > 0){
                    pq.offer(tmp);
                }
            }
        }
        return sb.length()==str.length() ? sb.toString() : "";
    }
}
