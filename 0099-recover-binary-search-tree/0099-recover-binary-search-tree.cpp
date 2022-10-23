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
    TreeNode* a=nullptr;
    TreeNode* b=nullptr;
    TreeNode* prev=nullptr;
    
    bool recoverTree2(TreeNode* root){
        if(!root) return false;
        
        if(recoverTree2(root->left)) return true;
        
        if(prev!=nullptr && prev->val > root->val){
            b=root;
            if(a==nullptr){
                a=prev;
            } else {
                return true;
            }
        }
        
        prev=root;
        if(recoverTree2(root->right)) return true;
        
        return false;
    }
    void recoverTree(TreeNode* root) {
        recoverTree2(root);
        
        if(a){
            int temp=a->val;
            a->val=b->val;
            b->val=temp;
        }
        
    }
};