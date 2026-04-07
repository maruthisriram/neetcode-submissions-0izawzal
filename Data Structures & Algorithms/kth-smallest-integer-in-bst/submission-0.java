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
    List<Integer> traversal = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        inorder(root);
        return traversal.get(k - 1);   
    }

    private void inorder(TreeNode root) {
        if(root!=null) {
            inorder(root.left);
            traversal.add(root.val);
            inorder(root.right);
        }
    }
}
