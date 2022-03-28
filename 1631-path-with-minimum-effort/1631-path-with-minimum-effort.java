class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        
        int[][] dis=new int[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                dis[i][j]=(int)(1e8);
            }
        }
        
        PriorityQueue<int[]> pq=new PriorityQueue<>((int[] a, int[] b)->{
            return a[2] - b[2];
        });
        
        pq.add(new int[]{0,0,0});
        dis[0][0]=0;
        
        int[][] dirs={{0,1},{1,0},{0,-1},{-1,0}};
        
        while(pq.size()>0){
            int[] p=pq.remove();
            
            int i=p[0];
            int j=p[1];
            int effort_till_now=p[2];
            
            if(dis[i][j] < effort_till_now) continue;
            
            if(i==n-1 && j==m-1) return effort_till_now;
            
            for(int[] dir:dirs){
                int x=i+dir[0];
                int y=j+dir[1];
                
                if(x>=0 && y>=0 && x<n && y<m){
                    int curr_effort=Math.abs(heights[i][j]-heights[x][y]);
                    
                    int final_effort=Math.max(curr_effort,effort_till_now);
                    
                    if(dis[x][y] > final_effort){
                        dis[x][y]=final_effort;
                        pq.add(new int[]{x,y,final_effort});
                    }
                }
            }
        }
        
        return dis[n-1][m-1];
    }
}