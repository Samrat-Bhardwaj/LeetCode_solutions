class Solution {
public:
    bool find132pattern(vector<int>& nums) {
        int n=nums.size();
        
        vector<int> msf(n);
        stack<int> st;
        msf[0]=nums[0];
        
        for(int i=1; i<n; i++){
            msf[i]=min(msf[i-1],nums[i]);
        }
        
        for(int j=n-1; j>=0; j--){
            if(msf[j]<nums[j]){
                while(st.size()!=0 && st.top()<=msf[j]){ // all the k elements should be greater than msf[j]
                    st.pop();
                }
                
                if(st.size()!=0 && st.top()<nums[j]){
                    return true;
                }
                
                st.push(nums[j]);
            }
        }
        
        return false;
    }
};