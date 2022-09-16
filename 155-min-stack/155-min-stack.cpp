class MinStack {
public:
    stack<long> st;
    long mine=0;
    MinStack() {
        
    }
    
    void push(int val) {
        if(st.size()==0){
            mine=(long)val;
            st.push((long)val);
        } else if(val<mine){
            long tp=((long)val-mine)+(long)val; // tp<val;
            st.push(tp);
            
            mine=(long)val;
        } else {
            st.push((long)val);
        }
    }
    
    void pop() {
        if(st.top()<mine){
            long val=mine;
            long tp=st.top();
            
            long old_min= val - tp + val;
            
            mine=old_min;
        }
        st.pop();
    }
    
    int top() {
        if(st.top()<mine){
            return (int)(mine);
        } else {
            return (int)st.top();
        }
    }
    
    int getMin() {
        return (int)mine;
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */