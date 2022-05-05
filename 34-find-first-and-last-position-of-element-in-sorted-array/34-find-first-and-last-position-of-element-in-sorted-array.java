class Solution {
    public int[] searchRange(int[] nums, int target) {
        int fi=-1;
        int li=-1;
        
        int si=0;
        int ei=nums.length-1;
        
        while(si<=ei){
            int mid=(si+ei)/2;
            
            if(nums[mid]==target){
                fi=mid;
            }
            
            if(nums[mid]<target){
                si=mid+1;
            } else {
                ei=mid-1;
            }
        }
        
        // li
        
        si=0;
        ei=nums.length-1;
        
        while(si<=ei){
            int mid=(si+ei)/2;
            
            if(nums[mid]==target){
                li=mid;
            }
            
            if(nums[mid]<=target){
                si=mid+1;
            } else {
                ei=mid-1;
            }
        }
        
        return new int[]{fi,li};
    }
}