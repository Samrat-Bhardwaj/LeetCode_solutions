class StockSpanner {
public:
    stack<pair<int,int>> st; // price,day
    int day=0;
    StockSpanner() {
        st.push({-1,-1});    
    }
    
    int next(int price) {
        while(st.top().second!=-1 && st.top().first <= price){
            st.pop();
        }
        
        int span = day - st.top().second; 
        st.push({price,day});
        day++;
        
        return span;
    }
};

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner* obj = new StockSpanner();
 * int param_1 = obj->next(price);
 */