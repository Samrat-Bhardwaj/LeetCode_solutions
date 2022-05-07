class Solution {
    public boolean check(int[] piles, int mid, int h){
        int total=0;
        
        for(int p:piles){
            int time=p/mid;
            
            if(p%mid!=0) time++;
            
            total+=time;
            if(total>h) return false;
        }
        
        return total<=h;
    }
    
    public int minEatingSpeed(int[] piles, int h) {
        int si=1;
        int ei=0;
        
        for(int e:piles) ei=Math.max(ei,e);
        
        while(si<=ei){
            int mid=(si+ei)/2;
            
            if(check(piles,mid,h)){
                ei=mid-1;
            } else {
                si=mid+1;
            }
        }
        
        return si;
    }
}