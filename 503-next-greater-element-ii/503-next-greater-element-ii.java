class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;

        int[] ngr=new int[n];
        Stack<Integer> st=new Stack<>();

        for(int i=2*n-1; i>=0; i--){
            int idx=i%n;
            
            int ele=nums[idx];

            while(st.size()>0 && nums[st.peek()]<=ele){
                st.pop();
            }

            if(st.size()==0){
                ngr[idx]=-1;
            } else {
                ngr[idx]=nums[st.peek()];
            }

            st.push(idx);
        }
        
        return ngr;
    }
}