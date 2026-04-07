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
    HashMap<Integer, Integer> valToIdx = new HashMap<>();
    int idx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            int val = inorder[i];
            valToIdx.put(val, i);
        }
        return construct(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode construct(int[] preorder, int[] inorder, int l, int h) {
        // System.out.println(l + " " + h + " " + idx);
        if(l>h || l < 0 || h >= inorder.length) return null;
        if(idx < preorder.length) {
            
            int val = preorder[idx];
            TreeNode root = new TreeNode(val);
            int inorderIdx = valToIdx.get(val);
            
            if(l <= (inorderIdx - 1)){
                idx++;
                root.left = construct(preorder, inorder, l, inorderIdx - 1);
            }else{
                root.left = null;
            }
            if((inorderIdx + 1) <= h){
                idx++;
                root.right = construct(preorder, inorder, inorderIdx + 1, h); 
            }else{
                root.right = null;
            }
            return root;
        }
        return null;
    }
}
