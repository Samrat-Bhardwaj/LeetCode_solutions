class Solution {
    public int rec(int idx, int n, int[] nums){
        if(idx==n-1){
            return 0;
        }
        
        int ans=(int)(1e8);
        
        int jumps_allowed=nums[idx];
        
        for(int j=1; j<=jumps_allowed && j+idx<n; j++){
            ans=Math.min(ans,rec(idx+j,n,nums));
        }
        
        return ans+1;
    }
    
     public int rec_memo(int idx, int n, int[] nums,int[] memo){
        if(idx==n-1){
            return memo[idx]=0;
        }
        
         if(memo[idx]!=0) return memo[idx];
         
        int ans=(int)(1e8);
        
        int jumps_allowed=nums[idx];
        
        for(int j=1; j<=jumps_allowed && j+idx<n; j++){
            ans=Math.min(ans,rec_memo(idx+j,n,nums,memo));
        }
        
        return memo[idx]=ans+1;
    }
    
    public int jump(int[] nums) {
        int n=nums.length;
        
        int[] memo=new int[n];
        return rec_memo(0,n,nums,memo);
        // return rec(0,n,nums);
    }
}