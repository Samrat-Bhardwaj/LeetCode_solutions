class Solution {
    public int[] twoSum(int[] nums, int target) {
        int si=0;
        int ei=nums.length-1;
        
        while(si<ei){
            int curr_sum=nums[si]+nums[ei];
            
            if(curr_sum<target){
                si++;
            } else if(curr_sum>target){
                ei--;
            } else {
                return new int[]{si+1,ei+1};
            }
        }
        
        return new int[]{};
    }
}