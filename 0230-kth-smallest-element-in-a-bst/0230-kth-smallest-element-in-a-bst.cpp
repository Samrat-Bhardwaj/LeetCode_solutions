/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    void addAllLeft(TreeNode* root,stack<TreeNode*>& st){
        TreeNode* curr=root;
        
        while(curr){
            st.push(curr);
            curr=curr->left;
        }
    }
    
    int kthSmallest(TreeNode* root, int k) {
        stack<TreeNode*> st;
        addAllLeft(root,st);
        
        while(k-- > 1){
            TreeNode* t=st.top(); st.pop();
            
            addAllLeft(t->right,st); // adding just larger elements
        }
        
        return st.top()->val;
    }
};