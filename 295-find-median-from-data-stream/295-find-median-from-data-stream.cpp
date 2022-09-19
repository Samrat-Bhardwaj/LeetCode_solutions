class MedianFinder {
public:
    priority_queue<int> left; // max pq
    priority_queue<int,vector<int>,greater<int>> right; // min pq
    
    MedianFinder() {
        
    }
    
    void addNum(int num) {
        if(left.size()==0 || left.top()>=num) left.push(num);
        else right.push(num);
        
        int ls=left.size();
        int rs=right.size();
        
        if(ls - rs > 1){
            right.push(left.top());
            left.pop();
        } else if(rs > ls){
            cout<<right.top();
            left.push(right.top());
            right.pop();
        }
    }
    
    double findMedian() {
        if(left.size()==right.size()){
            return ((1.0)*(left.top() + right.top()))/(2.0);
        } else {
            return left.top();
        }
    }
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */