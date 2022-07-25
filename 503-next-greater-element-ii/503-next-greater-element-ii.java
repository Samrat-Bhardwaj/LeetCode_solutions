class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;

        int[] ngr=new int[n];
        Stack<Integer> st=new Stack<>();

        for(int i=n-1; i>=0; i--){
            int ele=nums[i];

            while(st.size()>0 && nums[st.peek()]<=ele){
                st.pop();
            }

            if(st.size()==0){
                ngr[i]=-1;
            } else {
                ngr[i]=nums[st.peek()];
            }

            st.push(i);
        }

        for(int i=n-1; i>=0; i--){
            int ele=nums[i];

            while(st.size()>0 && nums[st.peek()]<=ele){
                st.pop();
            }

            if(st.size()==0){
                ngr[i]=-1;
            } else {
                ngr[i]=nums[st.peek()];
            }

            st.push(i);
        }

        return ngr;
    }
}