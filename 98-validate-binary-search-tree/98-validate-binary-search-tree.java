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
    class Pair {
        long min;
        long max;
        boolean isBST;
        
        public Pair(long min,long max, boolean isBST){
            this.min=min;
            this.max=max;
            this.isBST=isBST;
        }
    }
    
    public Pair isBst(TreeNode root){
        if(root==null){
            return new Pair(Long.MAX_VALUE,Long.MIN_VALUE,true);
        }
        
        if(root.left==null && root.right==null){
            return new Pair(root.val,root.val,true);
        }
        
        Pair lp=isBst(root.left);
        Pair rp=isBst(root.right);
        
        boolean currBST=false;
        
        if(lp.isBST && rp.isBST && lp.max<root.val && rp.min>root.val){
            currBST=true;
        }
        
        long min=Math.min(lp.min,root.val);
        long max=Math.max(rp.max,root.val);
        
        return new Pair(min,max,currBST);
    }
    
    public boolean isValidBST(TreeNode root) {
        return isBst(root).isBST;    
    }
}