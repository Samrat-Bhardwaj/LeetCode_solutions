class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        for(int i=0; i<n; i++){
            pq.add(nums[i]);
            
            if(pq.size()>k){
                pq.remove();
            }
        }
        
        return pq.peek();
    }
}