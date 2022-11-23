class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        
        int i=0; 
        int j=n-1;
        int[] ans = new int[2];
        
        while(i<j){
            int csum = nums[i] + nums[j];
            
            if(csum < target){
                i++;
            } else if(csum > target){
                j--;
            } else {
                ans[0]=i+1;
                ans[1]=j+1;
                return ans;
            }
        }
        
        return ans;
    }
}