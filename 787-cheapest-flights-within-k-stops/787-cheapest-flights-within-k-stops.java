class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] pre=new int[n];
        
        Arrays.fill(pre,(int)(1e8));
        pre[src]=0;
        
        for(int i=1; i<=k+1; i++){
            int[] curr=new int[n];
            
            for(int j=0; j<n; j++){
                curr[j]=pre[j];
            }
            
            for(int[] edge:flights){
                int u=edge[0];
                int v=edge[1];
                int w=edge[2];
                
                if(pre[u]+w<curr[v]){
                    curr[v] = pre[u] + w;
                }
            }
            
            pre=curr;
        }
        
        return pre[dst] == (int)(1e8) ? -1 : pre[dst];
    }
}