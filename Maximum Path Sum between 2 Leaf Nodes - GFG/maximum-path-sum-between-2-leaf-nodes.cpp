//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// Tree Node
struct Node {
    int data;
    Node *left;
    Node *right;

    Node(int val) {
        data = val;
        left = right = NULL;
    }
};

// Function to Build Tree
Node *buildTree(string str) {
    // Corner Case
    if (str.length() == 0 || str[0] == 'N') return NULL;

    // Creating vector of strings from input
    // string after spliting by space
    vector<string> ip;

    istringstream iss(str);
    for (string str; iss >> str;) ip.push_back(str);

    // Create the root of the tree
    Node *root = new Node(stoi(ip[0]));

    // Push the root to the queue
    queue<Node *> queue;
    queue.push(root);

    // Starting from the second element
    int i = 1;
    while (!queue.empty() && i < ip.size()) {

        // Get and remove the front of the queue
        Node *currNode = queue.front();
        queue.pop();

        // Get the current Node's value from the string
        string currVal = ip[i];

        // If the left child is not null
        if (currVal != "N") {

            // Create the left child for the current Node
            currNode->left = new Node(stoi(currVal));

            // Push it to the queue
            queue.push(currNode->left);
        }

        // For the right child
        i++;
        if (i >= ip.size()) break;
        currVal = ip[i];

        // If the right child is not null
        if (currVal != "N") {

            // Create the right child for the current Node
            currNode->right = new Node(stoi(currVal));

            // Push it to the queue
            queue.push(currNode->right);
        }
        i++;
    }

    return root;
}


// } Driver Code Ends
/*
struct Node
{
    int data;
    struct Node* left;
    struct Node* right;
    
    Node(int x){
        data = x;
        left = right = NULL;
    }
};
*/

class Solution {
public:
    // {left to node max sum, max ans}
    vector<int> rec(Node* root){
        if(!root){
            return {(int)(-1e8),(int)(-1e8)};
        }
        
        if(root->left==nullptr && root->right==nullptr){
            return {root->data,(int)(-1e8)};
        }
        
        vector<int> lans=rec(root->left);
        vector<int> rans=rec(root->right);
        
        int lsum=lans[0]; // leaf to node max sum
        int rsum=rans[0]; // leaf to node max sum
        
        int lmax=lans[1];
        int rmax=rans[1];
        
        vector<int> myAns(2,0);
        
        myAns[0]=max(lsum,rsum)+root->data;
        myAns[1]=max(lmax,max(rmax,lsum+rsum+root->data));
        
        return myAns;
    }
    int maxPathSum(Node* root)
    {
        vector<int> ans=rec(root);
        if(root->left==nullptr || root->right==nullptr) return max(ans[0],ans[1]);
        return ans[1];
    }
};

//{ Driver Code Starts.

int main() {
    int tc;
    scanf("%d ", &tc);
    while (tc--) {
        string treeString;
        getline(cin, treeString);
        Node *root = buildTree(treeString);
        Solution ob;
        cout << ob.maxPathSum(root) << "\n";
    }
    return 0;
}
// } Driver Code Ends