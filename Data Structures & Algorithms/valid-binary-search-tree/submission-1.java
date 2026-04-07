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
    public boolean isValidBST(TreeNode root) {
        boolean res = true;
        inorder(root);
        // System.out.println(traversal.toString());
        int prevValue = Integer.MIN_VALUE;
        for(Integer val:traversal) {
            if(val <= prevValue) return false;
            prevValue = val;
        }
        return res;
    }

    private void inorder(TreeNode root) {
        if(root!=null) {
            inorder(root.left);
            traversal.add(root.val);
            inorder(root.right);
        }
    }
}
