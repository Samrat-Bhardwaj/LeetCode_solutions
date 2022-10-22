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
    TreeNode* buildTree(vector<int>& preorder, int prsi, int prei,vector<int>& inorder, int insi,int inei){
        if(prsi > prei) return nullptr;
        
        TreeNode* root=new TreeNode(preorder[prsi]);
        
        int idx=insi;
        
        while(inorder[idx]!=root->val){
            idx++;
        }
        
        int count=idx-insi;
        
        root->left=buildTree(preorder,prsi+1,prsi+count,inorder,insi,idx-1);
        root->right=buildTree(preorder,prsi+count+1,prei,inorder,idx+1,inei);
        
        return root;
    }
    
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        return buildTree(preorder,0,preorder.size()-1,inorder,0,inorder.size()-1);
    }
};