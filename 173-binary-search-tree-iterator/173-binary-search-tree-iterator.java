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
class BSTIterator {
    Stack<TreeNode> st;
    public void addAllLeft(TreeNode root){
        while(root!=null){
            st.push(root);
            root=root.left;
        }   
    }
    
    public BSTIterator(TreeNode root) {
        st=new Stack<>();
        addAllLeft(root);
    }
    
    public int next() {
        TreeNode top=st.pop();
        
        addAllLeft(top.right);
        return top.val;
    }
    
    public boolean hasNext() {
        return st.size()>0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */