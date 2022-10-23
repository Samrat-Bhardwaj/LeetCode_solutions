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
    //{max path sum, max ans}
    vector<int> solve(TreeNode* root){
        if(!root) return {(int)(-1e8),(int)(-1e8)};
        
        // if(root->right==nullptr && root->left==nullptr){
        //     return {root->val,root->val};
        // }
        vector<int> lans=solve(root->left);
        vector<int> rans=solve(root->right);
        
        int lps=lans[0]; // left max path sum
        int rps=rans[0]; // right max path sum
        
        int lam=lans[1]; // left subtree max ans
        int ram=rans[1]; // right subtree max ans
        
        int mps=max(lps+root->val,max(rps+root->val,root->val)); // my max path sum 
        
        int mam=max(mps,max(lps+rps+root->val,max(lam,ram)));
        // cout<<root->val<<" "<<mps<<" "<<mam<<endl;
        return {mps,mam};
    }
    
    int maxPathSum(TreeNode* root) {
        return solve(root)[1];
    }
};