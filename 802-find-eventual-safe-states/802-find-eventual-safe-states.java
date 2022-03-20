class Solution {
    public boolean dfs(int src, int[][] graph, int[] vis){
        vis[src]=1;
        
        for(int nbr:graph[src]){
            if(vis[nbr]==0){
                boolean cycle=dfs(nbr,graph,vis);
                if(cycle) return true;
            } else if(vis[nbr]==1){
                return true;
            }
        }
        
        vis[src]=2;
        return false;
    }
    
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V=graph.length;
        
        int[] vis=new int[V];
        
        for(int i=0; i<V; i++){
            if(vis[i]==0){
                boolean cycle=dfs(i,graph,vis);            
            }
        }
        
        List<Integer> ans=new ArrayList<>();
        
        for(int i=0; i<V; i++){
            if(vis[i]==2){
                ans.add(i);
            }
        }
        
        return ans;
    }
}