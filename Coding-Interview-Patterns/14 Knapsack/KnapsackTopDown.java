
/*
Pattern: 0/1 Knapsack (Dynamic Programming)
01 0/1 Knapsack (medium)

Given two integer arrays to represent weights and profits of ‘N’ items,
we need to find a subset of these items which will give us maximum profit such that
their cumulative weight is not more than a given number ‘C’.
Each item can only be selected once, which means either we put an item in the knapsack or we skip it.
*/


// 2. Top-Down Dynamic Programming with Memoization

class KnapsackTopDown {
    public int Knapsack(int[] profits, int[] weights, int capacity){
      Integer[][] dp = new Integer[profits.length][capacity+1];
      return this.topdownKnapsack(dp, profits, weights, capacity, 0);
    }

    private int topdownKnapsack(Integer[][] dp, int[] profits, int[] weights, int capacity, int currentIndex){

        if(capacity <= 0 || currentIndex >= profits.length) return 0;

        //Memoization
        if(dp[currentIndex][capacity] != null){
          return dp[currentIndex][capacity];
        }

        // currentIndex profit Included
        int profitIncluded=0;
        if(weights[currentIndex] <= capacity){
          profitIncluded = profits[currentIndex] + topdownKnapsack(dp, profits, weights, capacity - weights[currentIndex], currentIndex+1);
        }
        // currentIndex profit Excluded
        int profitExcluded = topdownKnapsack(dp, profits, weights, capacity, currentIndex+1);
        dp[currentIndex][capacity] = Math.max(profitIncluded, profitExcluded);
        return dp[currentIndex][capacity];
    }/*
    Time Complexity: O(N*C) where N is the number of items and C is the knapsack capacity.
    Space Complexity: O(N*C)
    */

    public static void main(String[] args) {
      KnapsackTopDown ks = new KnapsackTopDown();
      int[] profits = {1, 6, 10, 16};
      int[] weights = {1, 2, 3, 5};
      int maxProfit = ks.Knapsack(profits, weights, 7);
      System.out.println("Total knapsack profit ---> " + maxProfit);
      maxProfit = ks.Knapsack(profits, weights, 6);
      System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}
