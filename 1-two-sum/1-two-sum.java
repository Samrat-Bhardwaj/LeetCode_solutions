class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        int[][] arr=new int[n][2];
        for(int i=0; i<n; i++){
            arr[i][0]=nums[i];
            arr[i][1]=i;
        }
        Arrays.sort(arr,(int[] a, int[] b)->{
            return a[0] - b[0];
        });
        
        int i=0;
        int j=nums.length-1;
        while(i<j){
            int s=arr[i][0]+arr[j][0];
            if(s<target){
                i++;
            } else if(s>target){
                j--;
            } else {
                return new int[]{arr[i][1],arr[j][1]};
            }
        }
        return new int[]{};
    }
}