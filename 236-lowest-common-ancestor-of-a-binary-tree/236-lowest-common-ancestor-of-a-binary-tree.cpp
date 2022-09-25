/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    bool lca_better(TreeNode* root, TreeNode* d1, TreeNode* d2,TreeNode*& lca){
        if(root==nullptr) return false;
        if(lca!=nullptr) return true;
        
        bool self=false;
        if(root==d1 || root==d2) self=true;
        
        bool left=lca_better(root->left,d1,d2,lca);
        bool right=lca_better(root->right,d1,d2,lca);
        
        if(lca!=nullptr) return true;
        if((left && right) || (self && left) || (self && right)) lca=root;
        
        return self || left || right;
    }
    
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        TreeNode* lca=nullptr;
        lca_better(root,p,q,lca);
        
        return lca;
    }
};