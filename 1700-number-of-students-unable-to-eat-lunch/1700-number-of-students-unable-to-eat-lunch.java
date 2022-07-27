class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Stack<Integer> st=new Stack<>();
        
        int n=students.length;
        
        for(int i=n-1; i>=0; i--){
            st.push(sandwiches[i]);
        }
        
        Queue<Integer> que=new ArrayDeque<>();
        
        for(int i=0; i<n; i++){
            que.add(students[i]);
        }
        
        while(st.size()>0){
            int curr_students = que.size();
            
            while(curr_students>0 && que.peek()!=st.peek()){
                int front_ele=que.remove();
                que.add(front_ele);
                
                curr_students--;
            }
            
            if(curr_students==0) return que.size();
            
            st.pop();
            que.remove();
        }
        
        return 0;
    }
}