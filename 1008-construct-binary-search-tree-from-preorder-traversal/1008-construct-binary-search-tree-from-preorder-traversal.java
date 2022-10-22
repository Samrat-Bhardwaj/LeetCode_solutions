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
    int idx=0;
    public TreeNode construct(int[] preorder, int lbound, int rbound){
        if(idx >= preorder.length || preorder[idx] <= lbound || preorder[idx] >= rbound){
            return null;
        }
        
        TreeNode root=new TreeNode(preorder[idx]);
        idx++;
        
        root.left=construct(preorder,lbound,root.val);
        root.right=construct(preorder,root.val,rbound);
        
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return construct(preorder,-1001,1001);
    }
}