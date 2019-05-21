/*
LeetCode 437. Path Sum III
*/


class Solution {
  public int pathSum(TreeNode root, int sum){
    if(root == null) return 0;
    return findPathSum(root, sum, 0) + pathSum(root.left, sum) + pathSum(root.right, sum);
  }

  public int findPathSum(TreeNode root, int sum, int curr){
    if(root == null) return 0;

    curr += root.val;
    if(curr == sum){
      return 1 + findPathSum(root.left, sum, curr) + findPathSum(root.right, sum, curr);
    }

    return findPathSum(root.left, sum, curr) + findPathSum(root.right, sum, curr);
  }
}
