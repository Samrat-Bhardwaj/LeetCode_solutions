class Solution {
    public int dfs(int i, int j, int[][] grid){
        grid[i][j]=0;
        
        int size=0;
        
        int[][] dirs={{0,1},{1,0},{0,-1},{-1,0}};
        
        for(int[] dir:dirs){
            int x=i+dir[0];
            int y=j+dir[1];
            
            if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]==1){
                size+=dfs(x,y,grid);
            }
        }
        
        return size+1;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        
        int ans=0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){
                    int size=dfs(i,j,grid);
                    ans=Math.max(ans,size);
                }
            }
        }
        
        return ans;
    }
}