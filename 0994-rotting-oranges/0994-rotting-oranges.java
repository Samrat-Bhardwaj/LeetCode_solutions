class Solution {
    public int orangesRotting(int[][] grid) {
        LinkedList<Integer> que=new LinkedList<>();
        
        int fresh_oranges=0;
        int n=grid.length;
        int m=grid[0].length;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==2){
                    int idx=i*m+j;
                    que.addLast(idx);
                } else if(grid[i][j]==1){
                    fresh_oranges++;
                }
            }
        }
        
        if(fresh_oranges==0) return 0;
        
        int time=0;
        int[][] dirs={{0,-1},{-1,0},{1,0},{0,1}};
        
        while(que.size()>0){
            int size=que.size();
            
            while(size-->0){
                int idx=que.removeFirst();
                
                int x=idx/m;
                int y=idx%m;
                
                for(int[] dir:dirs){
                    int i=x+dir[0];
                    int j=y+dir[1];
                    
                    if(i>=0 && j>=0 && i<n && j<m && grid[i][j]==1){
                        fresh_oranges--;
                        grid[i][j]=2;
                        que.addLast(i*m+j);
                    }
                }
            }
            time++;
        }
        
        return fresh_oranges == 0 ? time - 1 : -1;
    }
}