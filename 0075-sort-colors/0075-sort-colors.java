class Solution {
    void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public void sortColors(int[] nums) {
        int n=nums.length;
        
        int p1 = -1;
        int p2 = 0;
        int p3 = n-1;
        
        while(p2<=p3){ // until undiscovered area is not finish
            if(nums[p2]==2){
                swap(nums,p2,p3);
                p3--;
            } else if(nums[p2]==0){
                p1++;
                swap(nums,p1,p2);
                p2++;
            } else {
                p2++;
            }
        }
    }
}