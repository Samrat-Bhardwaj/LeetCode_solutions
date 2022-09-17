class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_map<int,int> map;
        
        for(int e:nums){
            map[e]++;
        }
        int ans=0;
        for(int e:nums){
            if(map.find(e)==map.end()) continue;
            
            int prev=e-1;
            int next=e+1;
            
            while(map.find(prev)!=map.end()){
                map.erase(prev);
                prev--;
            }
            
            while(map.find(next)!=map.end()){
                map.erase(next);
                next++;
            }
            
            int len = next - prev - 1;
            ans=max(ans,len);
        }
        
        return ans;
    }
};