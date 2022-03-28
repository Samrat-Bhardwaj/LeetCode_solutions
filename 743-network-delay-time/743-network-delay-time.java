class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<int[]>[] graph=new ArrayList[n];
        
        for(int i=0; i<n; i++){
            graph[i]=new ArrayList<>();
        }
        
        for(int[] edge:times){
            int u=edge[0]-1;
            int v=edge[1]-1;
            int w=edge[2];
            
            graph[u].add(new int[]{v,w});
        }
        
        PriorityQueue<int[]> pq=new PriorityQueue<>((int[] a, int[] b)->{
            return a[1] - b[1]; 
        });
        
        int[] dis=new int[n];
        Arrays.fill(dis,(int)(1e8));
        
        dis[k-1]=0;
        
        pq.add(new int[]{k-1,0});
        
        while(pq.size()!=0){
            int[] p=pq.remove();
            
            int node=p[0];
            int wsf=p[1];
            
            if(dis[node] < wsf) continue;
            
            for(int[] e:graph[node]){
                int v=e[0];
                int w=e[1];
                
                if(dis[v] > wsf + w){
                    dis[v]=wsf+w;
                    pq.add(new int[]{v,wsf+w});
                }
            }
        }
        
        int max_time=0;
        
        for(int i=0; i<n; i++){
            if(dis[i]==(int)(1e8)) return -1;
            max_time=Math.max(max_time,dis[i]);
        }
        
        return max_time;
    }
}