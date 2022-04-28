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
    int sum;
    public void makeGreater(TreeNode root){
        if(root==null) return;
        
        makeGreater(root.right);
        
        sum+=root.val;
        root.val=sum;
        
        makeGreater(root.left);
    }
    public TreeNode bstToGst(TreeNode root) {
        sum=0;
        makeGreater(root);
        return root;
    }
}