class Solution {
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>> pq;
        
        int n=matrix.size();
        int m=matrix[0].size();
        
        for(int i=0; i<n; i++){
            pq.push({matrix[i][0],i*m+0});
        }
        
        while(k-- > 1){
            pair<int,int> p=pq.top();
            pq.pop();
            
            int idx=p.second;
            
            int r=idx/m;
            int c=idx%m;
            
            if(c+1<m)
                pq.push({matrix[r][c+1],r*m+c+1});
        }
        
        return pq.top().first;
    }
};