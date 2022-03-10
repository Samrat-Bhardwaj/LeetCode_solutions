class Solution {
    class Pair implements Comparable<Pair> {
        int x;
        int h;
        
        public Pair(int x, int h){
            this.x=x;
            this.h=h;
        }
        
        public int compareTo(Pair o){
            if(this.x ==  o.x){
                return this.h - o.h;
            } else {
                return this.x - o.x;
            }
        }
    }
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<Pair> points=new ArrayList<>();
        
        for(int [] b:buildings){
            int sp=b[0];
            int ep=b[1];
            int h=b[2];
            
            Pair sph=new Pair(sp,-h);            
            Pair eph=new Pair(ep,h);
            
            points.add(sph);            
            points.add(eph);
        }
        
        Collections.sort(points);
        
        List<List<Integer>> ans=new ArrayList<>();
        
        int ch=0;
        
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        
        
        for(int i=0; i<points.size(); i++){
            Pair p=points.get(i);
            
            int x=p.x;
            int h=p.h;
            
            if(h<0){ // starting point
                pq.add((-1)*h);
            } else {
                pq.remove(h);
            }
            
            int max_height=pq.peek();
            
            if(ch!=max_height){
                List<Integer> sans=new ArrayList<>();
                sans.add(x);
                sans.add(max_height);
                
                ans.add(sans);
                
                ch=max_height;
            }
        }
        
        return ans;
        
    }
}