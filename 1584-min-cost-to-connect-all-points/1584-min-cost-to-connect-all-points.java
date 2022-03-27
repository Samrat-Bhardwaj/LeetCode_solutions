class Solution {
    int[] par;
  int[] size;

  public int findPar(int u){
        if(par[u]==u) return u;

        int p=findPar(par[u]);
        
        par[u]=p;

        return p;
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

    public int kruskal(int[][] edges, int n){
      par=new int[n+1];
      size=new int[n+1];

      for(int i=0; i<=n; i++){
        par[i]=i;
        size[i]=1;
      }

      Arrays.sort(edges,(int[] a, int [] b)->{
        return a[2]-b[2];
      });

      int cost=0;
      for(int[] edge:edges){
        int u=edge[0];
        int v=edge[1];
        int w=edge[2];

        int p1=findPar(u);
        int p2=findPar(v);

        if(p1!=p2){
          merge(p1,p2);
          cost+=w;
        }
      }

      return cost;
    }
    
    public int cost(int[] a, int[] b){
        return Math.abs(a[0]-b[0]) + Math.abs(a[1]-b[1]);
    }
    
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        int[][] edges=new int[(n*(n-1))/2][3];
        
        int k=0;
        for(int i=0; i<points.length; i++){
            for(int j=i+1; j<points.length; j++){
                edges[k][0]=i;
                edges[k][1]=j;
                edges[k][2]=cost(points[i],points[j]);
                k++;
            }
        }
        
        return kruskal(edges,points.length);
    }
}