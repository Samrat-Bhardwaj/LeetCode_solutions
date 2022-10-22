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
    public TreeNode build(int[] preorder, int si, int ei){
        if(si > ei) return null;
        if(si == ei) return new TreeNode(preorder[si]);
        
        TreeNode root=new TreeNode(preorder[si]);
        int idx=si+1;
        
        while(idx <= ei && preorder[idx] < root.val){
            idx++;
        }
        
        int count= idx - si - 1;
        root.left = build(preorder,si+1,si+count);
        root.right=build(preorder,idx,ei);
        
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int n=preorder.length;
        
        return build(preorder,0,n-1);
    }
}