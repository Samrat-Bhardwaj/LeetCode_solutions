class Solution {
public:
    int islandPerimeter(vector<vector<int>>& grid) {
        int ans=0;
        
        vector<vector<int>> dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        
        for(int i=0; i<grid.size(); i++){
            for(int j=0; j<grid[i].size(); j++){
                
                if(grid[i][j]==1){
                    
                    int nbrs=0;
                    for(vector<int> dir:dirs){
                        int x = i + dir[0];
                        int y = j + dir[1];

                        if(x>=0 && y>=0 && x<grid.size() && y<grid[0].size() && grid[x][y]==1){
                            nbrs++;
                        }
                    }
                    
                    ans+=(4-nbrs);
                }
            }
        }
        
        return ans;
    }
};