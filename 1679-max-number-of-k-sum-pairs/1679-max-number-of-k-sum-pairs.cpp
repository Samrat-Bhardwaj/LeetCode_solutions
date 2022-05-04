class Solution {
public:
    int maxOperations(vector<int>& nums, int k) {
        int ans=0;
        unordered_map<int,int> m;
        for(int e:nums){
            int temp=k-e;
            if(m.find(temp)!=m.end() && m[temp]>0){
                ans++;
                m[temp]--;
            } else {
                m[e]++;
            }
        }
        
        return ans;
    }
};