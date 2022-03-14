class Solution {
    public void dfs(int i, int j,char[][] grid,boolean[][] vis){
        int n=grid.length;
        int m=grid[0].length;
        vis[i][j]=true;
        
        int[][] dirs={{0,1},{1,0},{0,-1},{-1,0}};
        
        for(int[] dir:dirs){
            int x=i+dir[0];
            int y=j+dir[1];
            
            if(x>=0 && y>=0 && x<n && y<m && !vis[x][y] && grid[x][y]=='1'){
                dfs(x,y,grid,vis);
            }
        }
    }
    
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        
        boolean[][] vis=new boolean[n][m];
        
        int count=0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    dfs(i,j,grid,vis);
                    count++;
                }
            }
        }
        
        return count;
    }
}