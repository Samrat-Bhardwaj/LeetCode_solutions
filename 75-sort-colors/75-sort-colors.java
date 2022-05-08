class Solution {
    public void swap(int[] nums, int i, int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
    
    public void sortColors(int[] nums) {
        int p1=-1;
        int p2=0;
        int p3=nums.length-1;
        
        while(p2<=p3){
            if(nums[p2]==0){
                p1++;
                swap(nums,p1,p2);
                p2++;
            } else if(nums[p2]==2){
                swap(nums,p2,p3);
                p3--;
            } else {
                p2++;
            }
        }
    }
}