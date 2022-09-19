class FreqStack {
public:
    unordered_map<int,int> fre;
    unordered_map<int, stack<int>> stacks;
    int maxFre=0;
    
    FreqStack() {
        
    }
    
    void push(int val) {
        fre[val]++;
        
        maxFre=max(maxFre,fre[val]);
        // cout<<fre[val]<<" "<<val<<endl;
        stacks[fre[val]].push(val);
    }
    
    int pop() {
        // cout<<"Ff"<<maxFre<<"\n";
        int rv=stacks[maxFre].top();
        stacks[maxFre].pop();
        
        if(stacks[maxFre].size()==0) maxFre--;
        fre[rv]--;
        
        // if(fre[rv]==0) fre.erase(rv);
        
        return rv;
    }
};

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack* obj = new FreqStack();
 * obj->push(val);
 * int param_2 = obj->pop();
 */