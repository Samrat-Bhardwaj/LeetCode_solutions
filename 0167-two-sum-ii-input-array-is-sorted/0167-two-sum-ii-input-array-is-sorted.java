class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        
        int i=0; 
        int j=n-1;
        
        while(i<j){
            int csum = nums[i] + nums[j];
            
            if(csum < target){
                i++;
            } else if(csum > target){
                j--;
            } else {
                return new int[]{i+1,j+1};
            }
        }
        
        return new int[]{i,j};
    }
}