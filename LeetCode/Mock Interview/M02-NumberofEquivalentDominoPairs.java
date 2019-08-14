/*
1128. Number of Equivalent Domino Pairs
*/

class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        //max number of dominoes is 9, we need to acceess indexes 0-99 
        int[] counts = new int[100];
        int totalPairs = 0;
        
        for(int i=0; i<dominoes.length; i++){ //check every pair of dominoes
            
            int up = dominoes[i][0];
            int down = dominoes[i][1];
            
            if(up < down){ //make 'up' always bigger
                int temp = down;
                down = up;
                up = temp;
            }
            
            int currIndex = up*10 + down;
            
            //increase number of times we've seen exactly this pair            
            counts[currIndex]++;
            
            if(counts[currIndex] > 1){
                //every next same pair will contribute on 1 more than a previous one     
                totalPairs += counts[currIndex]-1;
            }
        }
        return totalPairs;
    }
}