/*
Longest string without 3 consecutive characters
*/

/*
Given A, B, C, find any string of maximum length that can be created such that no 3 consecutive characters are same.
There can be at max A 'a', B 'b' and C 'c'.

Input: A = 1, B = 1, C = 6
Output: "ccbccacc"

https://leetcode.com/problems/reorganize-string
https://leetcode.com/problems/distant-barcodes
https://leetcode.com/problems/rearrange-string-k-distance-apart (premium)
*/


class Solution {
    public class Node {
        char ch;
        int cnt;
        Node(char ch, int cnt){
            this.ch = ch;
            this.cnt = cnt;
        }
    }

    public String maxLenString(int A, int B, int C){

        Node nodeA = new Node('a', A);
        Node nodeB = new Node('b', B);
        Node nodeC = new Node('c', C);

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node a, Node b){
                return (b.cnt-a.cnt!=0 ? b.cnt-a.cnt : a.ch-b.ch);
            }
        });

        if(nodeA.cnt > 0) pq.offer(nodeA);
        if(nodeB.cnt > 0) pq.offer(nodeB);
        if(nodeC.cnt > 0) pq.offer(nodeC);

        StringBuilder sb = new StringBuilder();
        Queue<Node> queue = new LinkedList<>();
        while(!pq.isEmpty()){
            Node curr = pq.poll();
            sb.append(curr.ch);
            curr.cnt--;
            if(curr.cnt>0){
                sb.append(curr.ch);
                curr.cnt--;
            }

            queue.offer(curr);
            if(queue.size()==2){//k==2
                Node temp = queue.poll();
                if(temp.cnt>0) pq.offer(temp);
            }
        }
        return sb.toString();
    }
}
