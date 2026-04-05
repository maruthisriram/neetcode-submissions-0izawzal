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
    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        search(root, p, q);
        return res;
    }

    private void search(TreeNode root, TreeNode p, TreeNode q){
    if(root == null || res != null) return; // stop early if found

    if(p.val < root.val && q.val < root.val){
        search(root.left, p, q);
    } else if(p.val > root.val && q.val > root.val){
        search(root.right, p, q);
    } else {
        res = root; // found LCA
    }
}
}
