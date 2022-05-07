class Solution {
    public boolean check(int[] quantities, int mid, int stores){
        for(int q:quantities){
            int s=q/mid;
            
            if(q%mid!=0) s++;
            
            stores-=s;
            if(stores<0) return false;
        }
        
        return stores>=0;
    }
    
    public int minimizedMaximum(int n, int[] quantities) {
        int si=1;
        int ei=(int)(1e5);
        
        while(si<=ei){
            int mid=(si+ei)/2;
            
            if(check(quantities,mid,n)==false){
                si=mid+1;
            } else {
                ei=mid-1;
            }
        }
        
        return si;
    }
}