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
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<TreeNode> level = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>(); 
        if(root!=null){
            level.add(root);
            res.add(new ArrayList<>());
            res.get(res.size() - 1).add(root.val);
        }
        while(!level.isEmpty()){
            ArrayList<TreeNode> next = new ArrayList<>();
            for(TreeNode node:level){
                TreeNode left = node.left;
                TreeNode right = node.right;
                if(left!=null){
                    next.add(left);
                }
                if(right!=null){
                    next.add(right);
                }
            }
            if(!next.isEmpty()){
                res.add(new ArrayList<>());
                for(TreeNode node:next){
                    res.get(res.size() - 1).add(node.val);
                }
            }
            level = next;
        }
        return res;
    }
}
