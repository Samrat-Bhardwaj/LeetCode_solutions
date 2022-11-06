class Solution {
    public void dfs(int i, int j, char[][] grid){
        // vis mark
        grid[i][j]='0';

        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

        for(int[] dir:dirs){
            int x = i + dir[0];
            int y = j + dir[1];

            if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]=='1'){
                dfs(x,y,grid);
            }
        }
    }
    
    public int numIslands(char[][] grid) {
        int comps=0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='1'){
                    comps++;
                    dfs(i,j,grid);
                }
            }
        }

        return comps;
    }
}