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
    public TreeNode build(int[] inorder, int insi, int inei, int[] postorder, int posi, int poei){
        if(insi > inei) return null;
        
        TreeNode root=new TreeNode(postorder[poei]);
        
        int idx=insi;
        while(inorder[idx]!=root.val){
            idx++;
        }
        
        int count=idx-insi; // left elements count;
        
        root.left=build(inorder,insi,idx-1,postorder,posi,posi+count-1);
        root.right=build(inorder,idx+1,inei,postorder,posi+count,poei-1);
        
        return root;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=inorder.length;
        
        return build(inorder,0,n-1,postorder,0,n-1);
    }
}