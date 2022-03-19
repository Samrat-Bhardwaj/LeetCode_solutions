// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov + 1; i++)
                list.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = new Solution().topoSort(nov, list);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        
        if(V!=res.length)
        return false;
        
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}
// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    
    // if cycle -> return true
    static boolean dfs(int src,ArrayList<ArrayList<Integer>> graph,int[] vis,ArrayList<Integer> al){
        vis[src]=1;
        
        for(int nbr:graph.get(src)){
            if(vis[nbr]==0){
                boolean cycle=dfs(nbr,graph,vis,al);
                if(cycle) return true;
            } else if(vis[nbr]==1){
                return true;
            }
        }
        
        vis[src]=2;
        al.add(src);
        
        return false;
    }
    
    
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int[] vis=new int[V];
        ArrayList<Integer> al=new ArrayList<>();
        
        for(int i=0; i<V; i++){
            if(vis[i]==0){
                boolean cycle = dfs(i,adj,vis,al);
                
                if(cycle){
                    System.out.println("NO SOLUTION!!!!!!!");
                    return new int[]{};
                }
            }
        }
        
        int[] topo=new int[V];
        int j=0;
        
        for(int i=al.size()-1; i>=0; i--){
            topo[j]=al.get(i);
            j++;
        }
        
        return topo;
    }
}
