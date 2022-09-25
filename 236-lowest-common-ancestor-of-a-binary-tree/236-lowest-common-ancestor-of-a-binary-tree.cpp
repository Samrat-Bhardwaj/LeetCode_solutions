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
    vector<TreeNode*> nodeToRootPath(TreeNode* root, TreeNode* p){
        if(root==nullptr) return {};
        if(root==p){
            return {root};
        }
        
        vector<TreeNode*> left=nodeToRootPath(root->left,p);
        if(left.size()){
            left.push_back(root);
            return left;
        }
        
        vector<TreeNode*> right=nodeToRootPath(root->right,p);
        if(right.size()){
            right.push_back(root);
            return right;
        }
        
        return {};
    }
    
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        vector<TreeNode*> ntr1=nodeToRootPath(root,p);
        vector<TreeNode*> ntr2=nodeToRootPath(root,q);
        
        int i=ntr1.size()-1;
        int j=ntr2.size()-1;
        
        while(i>=0 && j>=0 && ntr1[i]==ntr2[j]){
            i--;
            j--;
        }
        
        return ntr1[i+1]; // ntr2[j+1];
    }
};