class Solution {
    int[] par;
    int[] size;
    
    public int findPar(int u){
        if(par[u]==u) return u;
        return par[u]=findPar(par[u]);
    }
    
    public void merge(int p1, int p2){
        if(size[p1]>=size[p2]){
            par[p2]=p1;
            size[p1]+=size[p2];
        } else {
            par[p1]=p2;
            size[p2]+=size[p1];
        }
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        par=new int[n];
        size=new int[n];
        
        for(int i=0; i<n; i++){
            par[i]=i;
            size[i]=1;
        }
        
        for(int[] edge:edges){
            int u=edge[0]-1;
            int v=edge[1]-1;
            
            int p1=findPar(u);
            int p2=findPar(v);
            
            if(p1!=p2){
                merge(p1,p2);
            } else {
                return edge;
            }
        }
        
        return new int[]{};
    }
}