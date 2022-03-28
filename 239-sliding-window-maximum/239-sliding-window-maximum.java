class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Stack<Integer> st=new Stack<>();
        int n=nums.length;
        
        int[] ngr=new int[n];
        
        ngr[n-1]=n;
        st.push(n-1);
        
        for(int i=n-2; i>=0; i--){
            int ele=nums[i];
            
            while(st.size()>0 && nums[st.peek()]<=ele){
                st.pop();
            }
            
            if(st.size()==0){
                ngr[i]=n;
            } else {
                ngr[i]=st.peek();
            }
            
            st.push(i);
        }
        
        int[] ans=new int[n-k+1];
        
        int j=0;
        for(int i=0; i<n-k+1; i++){
            if(j<i){
                j=i;
            }
            // window ending point
            int ep=i+k-1;
            
            while(ngr[j]<=ep){
                j=ngr[j];
            }
            
            ans[i]=nums[j];
        }
        
        return ans;
    }
}