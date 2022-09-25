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
    bool nodeToRootPath(TreeNode* root, TreeNode* p,vector<TreeNode*>& ntr){
        if(root==nullptr) return false;
        if(root==p){
            ntr.push_back(p);
            return true;
        }
        
        bool left=nodeToRootPath(root->left,p,ntr);
        bool right=nodeToRootPath(root->right,p,ntr);
        
        if(left || right){
            ntr.push_back(root);
            return true;
        }
        
        return false;
    }
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        vector<TreeNode*> ntr1;
        nodeToRootPath(root,p,ntr1);
        vector<TreeNode*> ntr2;
        nodeToRootPath(root,q,ntr2);
        
        int i=ntr1.size()-1;
        int j=ntr2.size()-1;
        
        while(i>=0 && j>=0 && ntr1[i]==ntr2[j]){
            i--;
            j--;
        }
        
        return ntr1[i+1]; // ntr2[j+1];
    }
};