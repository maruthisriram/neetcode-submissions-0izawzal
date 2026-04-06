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
    int res = 0;
    public int goodNodes(TreeNode root) {
        count(root, Integer.MIN_VALUE);
        return res;
    }

    private void count(TreeNode root, int maxVal) {
        if(root!=null){
            if(root.val >= maxVal) {
                res ++;
            }
            maxVal = Math.max(maxVal, root.val);
            count(root.left, maxVal);
            count(root.right, maxVal);
        }
    }
}
