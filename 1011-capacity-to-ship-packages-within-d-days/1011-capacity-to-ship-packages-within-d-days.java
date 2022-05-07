class Solution {
    public boolean check(int[] weights, int mid, int days){
        int curr_weight=0;
        int total_days=0;
        
        for(int i=0; i<weights.length; i++){
            int w=weights[i];
            if(w>mid) return false;
            
            if(curr_weight+w > mid){
                total_days++;
                curr_weight=w;
            } else {
                curr_weight+=w;
            }
            
            if(total_days>days) return false;
        }
        
        if(curr_weight>0) total_days++;
        
        return total_days<=days;
    }
    
    public int shipWithinDays(int[] weights, int days) {
        int si=1;
        int ei=(int)(1e9);
        
        
        while(si<=ei){
            int mid=(si+ei)/2;
            
            if(check(weights,mid,days)==false){
                si=mid+1;
            } else {
                ei=mid-1;
            }
        }
        
        return si;
    }
}