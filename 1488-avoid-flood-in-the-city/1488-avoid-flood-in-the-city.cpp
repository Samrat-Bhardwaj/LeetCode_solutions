class Solution {
public:
    vector<int> avoidFlood(vector<int>& rains) {
        unordered_map<int,int> filled;
        set<int> empty;
        
        vector<int> ans(rains.size(),-1);
        
        for(int i=0; i<rains.size(); i++){
            if(rains[i]==0){
                empty.insert(i);
                ans[i]=1;
            } else {
                int lake=rains[i];
                if(filled.find(lake)!=filled.end()){
                    int day=filled[lake]; // day it was rained on lake
                    
                    auto zidx=empty.lower_bound(day);
                        
                    if(zidx==empty.end()){
                        return {};
                    }
                    
                    int ld=*zidx;
                    
                    ans[ld]=lake;
                    empty.erase(ld);
                    filled[lake]=i;
                } else {
                    filled.insert({lake,i});
                }
                ans[i]=-1;
            }
        }
        
        return ans;
    }
};