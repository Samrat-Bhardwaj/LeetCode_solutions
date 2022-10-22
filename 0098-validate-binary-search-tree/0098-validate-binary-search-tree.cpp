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
    class bstPair {
        public:
            bool isBST=true;
            long minV=1e15;
            long maxV=-1e15;
            
            bstPair(){
                
            }
        
            bstPair(bool isBST, long minV, long maxV){
                this->isBST=isBST;
                this->minV=minV;
                this->maxV=maxV;
            }
    };
    
    bstPair* check(TreeNode* root){
        if(root==nullptr) return new bstPair(true,1e15,-1e15);
        
        bstPair* lp=check(root->left);
        bstPair* rp=check(root->right);
        
        bstPair* ansPair=new bstPair();
        if(!lp->isBST || !rp->isBST || lp->maxV >= root->val || rp->minV <=root->val){
            ansPair->isBST=false;
            return ansPair;
        }
        
        ansPair->minV=min(lp->minV,(long)root->val);
        ansPair->maxV=max(rp->maxV,(long)root->val);
        
        return ansPair;
    }
    
    bool isValidBST(TreeNode* root) {
        return check(root)->isBST;
    }
};