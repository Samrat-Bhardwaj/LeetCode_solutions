class Solution {
    public int maxDistance(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        
        LinkedList<Integer> que=new LinkedList<>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    que.addLast(i*m+j);
                }        
            }
        }
        
        if(que.size()==n*m) return -1;
        if(que.size()==0) return -1;
        
        int[][] dirs={{0,1},{1,0},{0,-1},{-1,0}};
        
        int level=0;
        while(que.size()>0){
            int size=que.size();
            
            while(size-->0){
                int idx=que.removeFirst();
                
                int i=idx/m;
                int j=idx%m;
                
                for(int[] dir:dirs){
                    int x=i+dir[0];
                    int y=j+dir[1];
                    
                    if(x>=0 && y>=0 && x<n && y<m && grid[x][y]==0){
                        que.addLast(x*m+y);
                        grid[x][y]=1;
                    }
                }
            }
            level++;
        }
        
        return level-1;
    }
}