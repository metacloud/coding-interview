
/*
Pattern: 0/1 Knapsack (Dynamic Programming)
01 0/1 Knapsack (medium)

Given two integer arrays to represent weights and profits of ‘N’ items,
we need to find a subset of these items which will give us maximum profit such that
their cumulative weight is not more than a given number ‘C’.
Each item can only be selected once, which means either we put an item in the knapsack or we skip it.
*/


// 1. Brute-Force Solution for Knapsack
class KnapsackRecursive {

    public int Knapsack(int[] profits, int[] weights, int capacity){
      return this.recursiveKnapsack(profits, weights, capacity, 0);
    }

    private int recursiveKnapsack(int[] profits, int[] weights, int capacity, int currentIndex){
      //basecase check
      if(capacity <=0 || currentIndex >= profits.length) return 0;

      //currentIndex profit Included.
      int profitIncluded = 0;
      if(weights[currentIndex] <= capacity){
        profitIncluded = profits[currentIndex] + recursiveKnapsack(profits, weights, capacity - weights[currentIndex], currentIndex+1);
      }

      //currentIndex profit Excluded.
      int profitExcluded = recursiveKnapsack(profits, weights, capacity, currentIndex+1);
      return Math.max(profitIncluded, profitExcluded);
    }/*
    Time Complexity: O(2^N)
    Space Complexity: O(N) : The space will be used to store the recursion stack.
    Because the recursive algorithm works in a depth-first,
    it means that we can't have more than n recursive calls on the call stack at any time.
    */

    public static void main(String[] args) {
      KnapsackRecursive ks = new KnapsackRecursive();
      int[] profits = {1, 6, 10, 16};
      int[] weights = {1, 2, 3, 5};
      int maxProfit = ks.Knapsack(profits, weights, 7);
      System.out.println("Total knapsack profit ---> " + maxProfit);
      maxProfit = ks.Knapsack(profits, weights, 6);
      System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}
