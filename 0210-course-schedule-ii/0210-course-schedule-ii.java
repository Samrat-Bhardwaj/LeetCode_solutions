class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        LinkedList<Integer> que = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i=0; i<numCourses; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] pre:prerequisites){
            int v = pre[0];
            int u = pre[1];
            
            indegree[v]++;
            graph[u].add(v);
        }
        
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0){
                que.addLast(i);
            }
        }
        
        while(que.size()>0){
            int u = que.removeFirst();
            ans.add(u);

            for(int e: graph[u]){
                if(--indegree[e]==0){
                    que.addLast(e);
                }
            }
        }
        
        if(ans.size() != numCourses) return new int[]{};
        
        int[] res = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            res[i] = ans.get(i);
        }
        
        return res;
    }
}