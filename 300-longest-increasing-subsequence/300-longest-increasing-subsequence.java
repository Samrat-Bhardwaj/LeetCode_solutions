class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        
        int[] dp=new int[n];
        
        int lis=0;
        
        for(int i=0; i<n; i++){
            dp[i]=1;
            
            for(int j=i-1; j>=0; j--){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            
            lis=Math.max(lis,dp[i]);
        }
        
//         for(int i=0; i<n; i++){
//             lis=Math.max(lis,dp[i]);
//         }
        
        return lis;
    }
}