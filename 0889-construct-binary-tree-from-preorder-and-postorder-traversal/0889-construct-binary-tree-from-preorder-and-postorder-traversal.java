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
    public TreeNode build(int[] preorder, int prsi, int prei, int[] postorder, int posi, int poei){
        if(prsi > prei) return null;
        if(prsi == prei) return new TreeNode(preorder[prsi]);
        
        TreeNode root=new TreeNode(preorder[prsi]);
        
        int idx=posi;
        while(postorder[idx] != preorder[prsi+1]){ // finding left subtree root
            idx++;
        }
        
        int count= idx - posi + 1;
        
        root.left=build(preorder,prsi+1,prsi+count,postorder,posi,idx);
        root.right=build(preorder,prsi+count+1,prei,postorder,idx+1,poei-1);
        
        return root;
    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n=preorder.length;
        
        return build(preorder,0,n-1,postorder,0,n-1);
    }
}