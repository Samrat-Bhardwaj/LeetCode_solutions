class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        // nlog(k);
        priority_queue<int,vector<int>,greater<int>> pq;
        
        for(int e:nums){
            pq.push(e);
            
            if(pq.size()>k){
                pq.pop();
            }
        }
        
        return pq.top();
    }
};