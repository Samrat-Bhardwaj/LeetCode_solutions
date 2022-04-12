class Solution {
    public int rec(int i, int j, int n, int m, int[][] grid){
        if(i==n-1 && j==m-1){
            return grid[i][j];
        }
        
        int ans=(int)(1e8);
        
        if(i+1<n)
            ans=Math.min(ans,rec(i+1,j,n,m,grid));
        
        if(j+1<m)
            ans=Math.min(ans,rec(i,j+1,n,m,grid));
        
        return ans+grid[i][j];
    }
    
    public int rec_memo(int i, int j, int n, int m, int[][] grid,int[][] memo){
        if(i==n-1 && j==m-1){
            return memo[i][j]= grid[i][j];
        }
        
        if(memo[i][j]!=0) return memo[i][j];
        
        int ans=(int)(1e8);
        
        if(i+1<n)
            ans=Math.min(ans,rec_memo(i+1,j,n,m,grid,memo));
        
        if(j+1<m)
            ans=Math.min(ans,rec_memo(i,j+1,n,m,grid,memo));
        
        return memo[i][j]=ans+grid[i][j];
    }
    
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        
        int[][] memo=new int[n][m];
        
        return rec_memo(0,0,n,m,grid,memo);
        
        // return rec(0,0,n,m,grid);
    }
}