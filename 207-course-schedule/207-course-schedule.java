class Solution {
    public boolean dfs(ArrayList<Integer>[] graph, int src, int[] vis){
        vis[src]=1;
        
        for(int nbr:graph[src]){
            if(vis[nbr]==0){
                boolean cycle=dfs(graph,nbr,vis);
                if(cycle) return true;
            } else if(vis[nbr]==1){
                return true;
            }
        }
        
        vis[src]=2;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph=new ArrayList[numCourses];
        
        for(int i=0; i<graph.length; i++)
            graph[i]=new ArrayList<>();
        
        for(int[] edge:prerequisites){
            int a=edge[0];
            int b=edge[1];
            
            graph[b].add(a);
        }
        
        int[] vis=new int[numCourses];
        // ArrayList<Integer> topo=new ArrayList<>()
        
        for(int i=0; i<vis.length; i++){
            if(vis[i]==0){
                boolean cycle=dfs(graph,i,vis);
                if(cycle) return false;
            }
        }
        
        return true;
    }
}