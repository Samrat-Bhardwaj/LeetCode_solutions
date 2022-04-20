class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        
        int inc=nums[0];
        int exc=0;
        
        for(int i=1; i<n; i++){
            int ninc=exc+nums[i];
            int nexc=Math.max(inc,exc);
            
            inc=ninc;
            exc=nexc;
        }
        
        return Math.max(inc,exc);
    }
}