class Solution {
    public int singleNumber(int[] nums) {
        int ans=0;
        for(int e:nums){
            ans^=e;
        }
        
        return ans;
    }
}