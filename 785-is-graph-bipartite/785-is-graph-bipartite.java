class Solution {
    public boolean isEven(ArrayList<Integer>[] graph, int src, int[] vis){
        LinkedList<Integer> que=new LinkedList<>();
        
        que.addLast(src);
        
        int color=0;
        
        while(que.size()>0){
            int size=que.size();
            
            while(size-->0){
                int t=que.removeFirst();
                
                if(vis[t]!=-1){ // already visited 
                    if(vis[t]!=color) return false;
                }
                
                vis[t]=color;
                
                for(int nbr:graph[t]){
                    if(vis[nbr]==-1){
                        que.addLast(nbr);
                    }
                }
            }
            
            color=(color+1)%2;
        }
        
        return true;
    }
    
    public boolean isBipartite(int[][] graph) {
        int vtces=graph.length;
        
        ArrayList<Integer>[] myGraph=new ArrayList[vtces];
        
        for(int i=0; i<vtces; i++){
            myGraph[i]=new ArrayList<>();
        }
        
        for(int i=0; i<vtces; i++){
            for(int v:graph[i]){
                myGraph[i].add(v);
            }
        }
        
        int[] vis=new int[vtces];
        Arrays.fill(vis,-1);
        
        for(int i=0; i<vtces; i++){
            if(vis[i]==-1){
                boolean even=isEven(myGraph,i,vis);
                if(even==false) return false;
            }
        }
        
        return true;
    }
}