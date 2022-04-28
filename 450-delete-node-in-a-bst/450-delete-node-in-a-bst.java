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
    public int leftMax(TreeNode root){
        while(root.right!=null){
            root=root.right;
        }
        
        return root.val;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return root;
        
        if(root.val==key){
            if(root.left==null){
                return root.right;
            }
            
            if(root.right==null){
                return root.left;
            }
            
            // i have both children, lmax or rmin
            int lmax=leftMax(root.left);
            
            root.val=lmax;
            root.left=deleteNode(root.left,lmax);
            
            return root;
        }
        
        if(root.val<key){
            root.right=deleteNode(root.right,key);
        } else {
            root.left=deleteNode(root.left,key);
        }
        return root;
    }
}