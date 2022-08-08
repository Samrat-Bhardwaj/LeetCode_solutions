class MinStack {
    Stack<Long> st;
    long min;
    
    public MinStack() {
        st=new Stack<>();
        min=Long.MAX_VALUE;
    }
    
    public void push(int x) {
        if(st.size()==0){
            min=(long)x;
            st.push((long)x);
            return;
        }    
        
        if(x<min){
            long to_push=((long)(x)-min)+(long)(x); 
            
            st.push(to_push);
            min=((long)(x));
        } else {
            st.push((long)(x));
        }
    }
    
    public void pop() {
        if(st.peek()<min){ // we are popping encrypted value
            long tp=st.pop();
            
            long x=min;
            long old_min=2*x-tp;
            
            min=old_min;
        } else {
            st.pop();
        }
    }
    
    public int top() {
         long tr;
        if(st.peek()<min){ 
            tr=min;
        } else {
            tr=st.peek();
        }
        
        return (int)tr;
    }
    
    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */