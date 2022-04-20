class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        
        int[] inc=new int[n];
        int[] exc=new int[n];
        
        inc[0]=nums[0];
        exc[0]=0;
        
        for(int i=1; i<n; i++){
            inc[i]=exc[i-1]+nums[i];
            exc[i]=Math.max(inc[i-1],exc[i-1]);
        }
        
        return Math.max(inc[n-1],exc[n-1]);
    }
}