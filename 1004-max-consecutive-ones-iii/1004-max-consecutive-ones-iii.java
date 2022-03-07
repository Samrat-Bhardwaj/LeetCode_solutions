class Solution {
    public int longestOnes(int[] nums, int k) {
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
            
            while(count>k){
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