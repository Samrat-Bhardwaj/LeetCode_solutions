class Solution {
    public int maxLen(int arr[], int n){
        HashMap<Integer,Integer> map=new HashMap<>();
        
        int csum=0;
        int ans=0;
        
        map.put(csum,-1);
        
        for(int i=0; i<n; i++){
            csum+=arr[i];
            
            if(map.containsKey(csum)){
                int len=i-map.get(csum);
                ans=Math.max(ans,len);
            } else {
                map.put(csum,i);
            }
        }
        
        return ans;
    }
    
    public int findMaxLength(int[] nums) {
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                nums[i]=-1;
            }
        }
        
        return maxLen(nums,nums.length);
    }
}