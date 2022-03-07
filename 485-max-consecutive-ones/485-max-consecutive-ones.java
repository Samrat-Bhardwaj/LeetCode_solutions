class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int si=0;
        int ei=0;
        
        int ans=0;
        
        int count=0;
        int n=nums.length;
        
        while(ei<n){
            if(nums[ei]==0){
                count++;
            }
            
            ei++;
            
            while(count>0){
                if(nums[si]==0){
                    count--;
                }
                si++;
            }
            
            int len=ei-si;
            ans=Math.max(ans,len);
        }
        
        return ans;
    }
}