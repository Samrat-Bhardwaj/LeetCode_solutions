class Solution {
public:
    vector<int> getNextGreater(vector<int> nums){
    int n=nums.size();

    stack<int> st;
    vector<int> ngr(n,n+1);

    for(int i=0; i<n; i++){
        while(st.size()!=0 && nums[st.top()]<nums[i]){
            ngr[st.top()]=i;
            st.pop();
        }

        st.push(i);
    }

    return ngr;
}

vector<int> maxSlidingWindow(vector<int>& nums, int k) {
    vector<int> ngr=getNextGreater(nums);     
    
    int n=nums.size();
    vector<int> ans(n-k+1);

    int cand=0;
    for(int i=0; i<n-k+1; i++){
        if(cand<i){
            cand=i;
        }

        while(ngr[cand]<=i+k-1){
            cand=ngr[cand];
        }

        ans[i]=nums[cand];
    }

    return ans;
}

};