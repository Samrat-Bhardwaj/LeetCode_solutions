/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
/*    public static class Pair implements Comparable<Pair>{
        int v;
        int p;
        public Pair(int a, int b){
            this.v=a;
            this.p=b;
        }
        public  int compareTo(Pair o){
            return this.p-o.p;
        }
    }
    static int min;
    static int max;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        min=Integer.MAX_VALUE;
        max=Integer.MIN_VALUE;
        ArrayList<Pair> al= new ArrayList<> ();
        some(al,root,0);
        // Collections.sort(al);
        int yo=max-min+1;
        List<List<Integer>> ans=new ArrayList<> ();
        for(int i=0; i<yo; i++){
            ans.add(new ArrayList<> ());
        }
        HashMap<Integer,List<Integer>> map=new HashMap<> ();
        for(Pair p: al){
            if(map.containsKey(p.p)){
                List<Integer> temp=map.get(p.p);
                temp.add(p.v);
            } else {
                List<Integer> temp=new ArrayList<> ();
                temp.add(p.v);
                map.put(p.p, new ArrayList(temp));
            }
        }
        Iterator<Map.Entry<Integer,List<Integer>>> it=map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry en=it.next();
            //System.out.println((int)en.getKey()-min);
             List<Integer> temp=(List<Integer>)en.getValue();
            Collections.sort(temp);
            ans.remove((int)en.getKey()-min);
            ans.add((int)en.getKey()-min,new ArrayList<> (temp));
        }
        return ans;
    }
    public static void some(ArrayList<Pair> al, TreeNode root, int i){
        if(root==null) return;
        min=Math.min(min,i);
        max=Math.max(max,i);
        al.add(new Pair(root.val,i));
        some(al,root.left,i-1);
        some(al,root.right,i+1);
    }*/
     int min=0, max=0;
    Map<Integer, List<Integer>> map = new HashMap();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if(root==null) return res;
        Queue<TreeNode> qt = new LinkedList();
        Queue<Integer> qi = new LinkedList();
        qt.add(root);
        qi.add(0);//not root.val
        while(!qt.isEmpty()){
            int size = qt.size();
            Map<Integer,List<Integer>> tmp = new HashMap();
            for(int i=0;i<size;i++){
                TreeNode cur = qt.poll();
                int idx = qi.poll();
                if(!tmp.containsKey(idx)) tmp.put(idx, new ArrayList<Integer>());
                tmp.get(idx).add(cur.val);
                if(idx<min)  min = idx;
                if(idx>max)  max = idx;
                if(cur.left!=null){
                    qt.add(cur.left);
                    qi.add(idx-1);
                }
                if(cur.right!=null){
                    qt.add(cur.right);
                    qi.add(idx+1);
                } 
            }
            for(int key : tmp.keySet()){
                if(!map.containsKey(key)) map.put(key, new ArrayList<Integer>());
                List<Integer> list = tmp.get(key);
                Collections.sort(list);
                map.get(key).addAll(list);
            }
            
        }
        for (int i=min; i<=max; i++){
            List<Integer> list = map.get(i);
            res.add(list);
        }
        return res;
    }
}
