class Solution {
    public boolean dfs(ArrayList<Integer>[] graph, int src, int[] vis,ArrayList<Integer> topo){
        vis[src]=1;
        
        for(int nbr:graph[src]){
            if(vis[nbr]==0){
                boolean cycle=dfs(graph,nbr,vis,topo);
                if(cycle) return true;
            } else if(vis[nbr]==1){
                return true;
            }
        }
        
        vis[src]=2;
        topo.add(src);
        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
         ArrayList<Integer>[] graph=new ArrayList[numCourses];
        
        for(int i=0; i<graph.length; i++)
            graph[i]=new ArrayList<>();
        
        for(int[] edge:prerequisites){
            int a=edge[0];
            int b=edge[1];
            
            graph[b].add(a);
        }
        
        int[] vis=new int[numCourses];
        ArrayList<Integer> topo=new ArrayList<>();
        
        for(int i=0; i<vis.length; i++){
            if(vis[i]==0){
                boolean cycle=dfs(graph,i,vis,topo);
                if(cycle) return new int[]{};
            }
        }
        
        int[] ans=new int[numCourses];
        for(int i=0; i<ans.length; i++){
            ans[i]=topo.get(numCourses-i-1);
        }
        
        return ans;
    }
}