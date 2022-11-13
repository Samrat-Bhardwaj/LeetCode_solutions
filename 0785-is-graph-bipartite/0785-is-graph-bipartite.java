class Solution {
    public boolean isOddCycle(int src, int[][] graph, int[] vis){
        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(src);

        int color = 0; // level
        while(que.size()>0){
            int size = que.size();

            while(size -- > 0){
                int u = que.removeFirst();

                if(vis[u]!=-1){
                    if(vis[u]!=color) return true;
                    continue;
                }
                // removal time mark
                vis[u] = color;

                for(int v : graph[u]){
                    if(vis[v]==-1){
                        que.addLast(v);
                    }
                }
            }
            color = (color+1)%2;
        }

        return false;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        Arrays.fill(vis,-1); 

        for(int i=0; i<graph.length; i++){
            if(vis[i]==-1){
                if(isOddCycle(i, graph, vis)) return false;
            }
        }

        return true;
    }
}