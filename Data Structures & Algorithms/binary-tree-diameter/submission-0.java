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
    int res = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return res;
    }

    private int diameter(TreeNode root){
        if(root==null) return 0;
        int leftLength = diameter(root.left);
        int rightLength = diameter(root.right);
        res = Math.max(res, leftLength + rightLength);
        res = Math.max(res, Math.max(leftLength, rightLength));
        return 1 + Math.max(leftLength, rightLength);
    }
}
