class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<n; i++){
            pq.add(nums[i]);
        }
        
        int ans=-1;
        
        while(k>0){
            ans=pq.remove();
            k--;
        }
        
        return ans;
    }
}