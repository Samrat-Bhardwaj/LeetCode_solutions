class Solution {
    public int orangesRotting(int[][] grid) {
        LinkedList<Integer> que=new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;

        int fresh_oranges=0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    fresh_oranges++;
                } else if(grid[i][j]==2) {
                    int idx=i*m+j;
                    que.addLast(idx);
                }
            }
        }
        
        if(fresh_oranges==0) return 0;

        int level=0;
        int[][] dirs={{0,1},{1,0},{0,-1},{-1,0}};

        while(que.size()>0){
            int size=que.size();

            while(size-->0){
                int idx=que.removeFirst();

                int i=idx/m;
                int j=idx%m;

                for(int[] dir:dirs){
                    int x=i+dir[0];
                    int y=j+dir[1];

                    if(x>=0 && y>=0 && x<n && y<m && grid[x][y]==1){
                        que.addLast(x*m+y);
                        grid[x][y]=2; // rotting oranges
                        fresh_oranges--;
                    }
                }
            }
            level++;
        }

        return fresh_oranges == 0 ? level - 1  : -1;
    }
}