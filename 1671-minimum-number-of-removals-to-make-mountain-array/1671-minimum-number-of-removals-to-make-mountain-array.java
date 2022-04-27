class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n=nums.length;
        
        int[] dps=new int[n];
        int[] dpe=new int[n];
        
        for(int i=0; i<n; i++){
            dps[i]=1;
            for(int j=i-1; j>=0; j--){
                if(nums[i]>nums[j]){
                    dps[i]=Math.max(dps[i],dps[j]+1);
                }
            }
        }
        
        for(int i=n-1; i>=0; i--){
            dpe[i]=1;
            for(int j=i+1; j<n; j++){
                if(nums[i]>nums[j]){
                    dpe[i]=Math.max(dpe[i],dpe[j]+1);
                }
            }
        }
        
        int lbs=0;
        for(int i=1; i<n-1; i++){
            if(dps[i]==1) continue;
            if(dpe[i]==1) continue;
            lbs=Math.max(lbs,dps[i]+dpe[i]-1);
        }
        
        return n-lbs;
    }
}