class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        stack<int> st;  
        int n=nums.size();

        vector<int> ans(n,-1);

        for(int i=0; i<2*n; i++){
            while(st.size()!=0 && nums[st.top()]<nums[i%n]){
                ans[st.top()]=nums[i%n];
                st.pop();
            }

            if(i<n)
               st.push(i);
        }      

        return ans;  
    }
};