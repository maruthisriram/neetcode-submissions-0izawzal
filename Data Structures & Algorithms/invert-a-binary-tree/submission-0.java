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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        if(left==null) {
            root.right = null;
        }else{
            root.right = new TreeNode(left.val, left.left, left.right);
        }
        if(right==null){
            root.left = null;
        }else{
            root.left = new TreeNode(right.val, right.left, right.right);
        }
        return root;
    }
}
