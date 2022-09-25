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
    
    void klevelDown(TreeNode* root, TreeNode* blocker, int k,vector<int>& ans){
        if(root==nullptr || root==blocker) return;

        if(k==0){
            ans.push_back(root->val);
        }

        klevelDown(root->left,blocker,k-1,ans);
        klevelDown(root->right,blocker,k-1,ans);
    }

    vector<int> distanceK(TreeNode* root, TreeNode* target, int k) {
        vector<TreeNode*> ntr=nodeToRootPath(root,target);

        vector<int> ans;
        TreeNode* blocker=nullptr;

        for(int i=0; i<ntr.size(); i++){
            TreeNode* currNode=ntr[i];

            klevelDown(currNode,blocker,k-i,ans);
            blocker=currNode;
        }

        return ans;
    }
};