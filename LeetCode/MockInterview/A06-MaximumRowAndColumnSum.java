/*
Find the sum of maximum row sum and maximum column sum
*/


class Solution {
    public int[] findMaxSum(int[][] grid){

        int row = -1, col = -1;
        int maxRow = Integer.MIN_VALUE, maxCol = Integer.MIN_VALUE;
        for(int i=0; i<grid.length; i++){
            int rowSum = 0, colSum = 0;
            for(int j=0; j<grid[i].length; j++){
                rowSum += grid[i][j];
                colSum += grid[j][i];
            }

            if(rowSum > maxRow){
                maxRow = rowSum;
                row = i;
            }
            if(colSum > maxCol){
                maxCol = colSum;
                col = i;
            }
        }

        return new int[] {row, col};
    }
}
