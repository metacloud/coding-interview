/*
48. Rotate Image
*/

class Solution {
    public void rotate(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return;

        Collections.reverse(Arrays.asList(matrix));
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
