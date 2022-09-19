class Solution {
public:
    vector<string> topKFrequent(vector<string>& words, int k) {    
        unordered_map<string,int> m;
        for(string s:words){
            m[s]++;
        }
        
         auto comp = [&](const pair<string,int>& a, const pair<string,int>& b) {
            return a.second > b.second || (a.second == b.second && a.first < b.first);
        };
        
        typedef priority_queue< pair<string,int>, vector<pair<string,int>>, decltype(comp) > my_priority_queue_t;
        my_priority_queue_t  pq(comp);
        
        for(auto it:m){
            pq.push(it);
            
            if(pq.size()>k){
                pq.pop();
            }
        }
        
        vector<string> ans;
        
        while(pq.size()){
            ans.push_back(pq.top().first);
            pq.pop();
        }
        
        reverse(ans.begin(),ans.end());
        
        return ans;
    }
};