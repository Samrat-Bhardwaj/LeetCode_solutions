class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        unordered_map<int,int> map;
        
        vector<int> ans;
        for(int e:nums1){
            map[e]++;
        }
        
        for(int e:nums2){
            if(map.find(e)!=map.end()){
                ans.push_back(e);
                
                map[e]--;
                if(map[e]==0){
                    map.erase(e);
                }
            }
        }
        
        return ans;
    }
};