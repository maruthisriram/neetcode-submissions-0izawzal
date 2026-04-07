/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        pathSum(root);
        return res;
    }

    private int pathSum(TreeNode root) {
        if(root==null) return 0;
        int leftSum = pathSum(root.left);
        int rightSum = pathSum(root.right);
        res = Math.max(res, Math.max(leftSum + rightSum + root.val, root.val));
        res = Math.max(res, Math.max(root.val + leftSum, root.val + rightSum));
        return Math.max(root.val, Math.max(leftSum + root.val, rightSum + root.val));
    }
}
