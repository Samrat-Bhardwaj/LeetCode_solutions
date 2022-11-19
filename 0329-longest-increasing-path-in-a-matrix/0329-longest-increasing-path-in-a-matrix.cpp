class Solution {
public:
int longestIncreasingPath(vector<vector<int>>& matrix) {
    int n=matrix.size();
    int m=matrix[0].size();

    vector<vector<int>> indegree(n,vector<int>(m,0));
    vector<vector<int>> dirs = {{0,1},{1,0},{0,-1},{-1,0}};

    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            for(auto dir:dirs){
                int x = i+dir[0];
                int y = j+dir[1];

                if(x>=0 && y>=0 && x<n && y<m && matrix[x][y] > matrix[i][j]){
                    indegree[x][y]++; // edge (i,j) -> (x,y);
                }
            }
        }
    }

    queue<int> q;
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            if(indegree[i][j]==0){
                q.push(i*m + j);
            }
        }
    }

    int level=0;
    while(q.size()){
        int size=q.size();
        while(size -- > 0){
            int idx = q.front(); q.pop();

            int i = idx/m;
            int j = idx%m;

            for(auto dir:dirs){
                int x = i+dir[0];
                int y = j+dir[1];

                if(x>=0 && y>=0 && x<n && y<m && matrix[x][y] > matrix[i][j]){
                    if(--indegree[x][y]==0){
                        q.push(x*m+y);
                    }
                }
            }
        }
        level++;
    }

    return level;
}
};