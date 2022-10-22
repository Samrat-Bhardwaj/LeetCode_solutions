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
    int getMin(TreeNode* root){
        TreeNode* curr=root;

        while(curr->left!=nullptr){
            curr=curr->left;
        }

        return curr->val;
    }
    
    TreeNode* deleteNode(TreeNode* root, int key) {
        if(root==nullptr) return nullptr;
        
        if(root->val < key){
            root->right=deleteNode(root->right,key);
        } else if(root->val > key){
            root->left=deleteNode(root->left,key);
        } else {
            // if its a leaf node
            if(root->left==nullptr && root->right==nullptr){
                return nullptr;
            }
            
            // if it has one child 
            if(root->left==nullptr){
                return root->right;
            }
            if(root->right==nullptr){
                return root->left;
            }
            
            // if it has 2 children
            int justLarger=getMin(root->right);
            
            root->val=justLarger;
            root->right=deleteNode(root->right,justLarger);
        }
        
        return root;
    }
};