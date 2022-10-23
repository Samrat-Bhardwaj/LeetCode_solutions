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
class BSTIterator {
public:
    stack<TreeNode*> st;
    void addAllLeft(TreeNode* root){
        TreeNode* curr=root;

        while(curr){
            st.push(curr);
            curr=curr->left;
        }
    }
    
    BSTIterator(TreeNode* root) {
        addAllLeft(root);
    }
    
    int next() {
        TreeNode* t=st.top(); st.pop();
        addAllLeft(t->right);
        
        return t->val;
    }
    
    bool hasNext() {
        return st.size()!=0;
    }
};

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator* obj = new BSTIterator(root);
 * int param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */