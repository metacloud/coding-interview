/*
121. Best Time to Buy and Sell Stock
*/

class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        if(prices==null || prices.length==0) return maxProfit;

        int buy = prices[0];
        for(int i=1; i<prices.length; i++){
            if(buy > prices[i]) buy = prices[i];
            else {
                maxProfit = Math.max(maxProfit, prices[i]-buy);
            }
        }
        return maxProfit;
    }
} /*
Time Complexity: O(N)
Space Complexity: O(1)
*/
