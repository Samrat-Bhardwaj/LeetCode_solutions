/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public ArrayList<TreeNode> nodeToRootPath(TreeNode root, TreeNode data){
        if(root==null) return new ArrayList<>();
        
    if(root==data){
      ArrayList<TreeNode> ba=new ArrayList<>();
      ba.add(root);
      return ba;
    }

    ArrayList<TreeNode> la=nodeToRootPath(root.left,data);
    if(la.size()>0){
      la.add(root);
      return la;
    }

    ArrayList<TreeNode> ra=nodeToRootPath(root.right,data);
    if(ra.size()>0){
      ra.add(root);
      return ra;
    }

    return new ArrayList<>();
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> ntr1=nodeToRootPath(root,p);
        ArrayList<TreeNode> ntr2=nodeToRootPath(root,q);
        
        int i=ntr1.size()-1;
        int j=ntr2.size()-1;
        
        while(i>=0 && j>=0 && ntr1.get(i)==ntr2.get(j)){
            i--;
            j--;
        }
        
        return ntr1.get(i+1);
    }
}