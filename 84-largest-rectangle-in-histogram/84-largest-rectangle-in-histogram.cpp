class Solution {
public:
vector<int> nsor(vector<int> arr, int n){
    vector<int> nsr(n,0);

    stack<int> st;

    for(int i=n-1; i>=0; i--){
        int ele=arr[i];

        while(st.size()!=0 && arr[st.top()]>=ele){
            st.pop();
        }

        if(st.size()==0){
            nsr[i]=n;
        } else {
            nsr[i]=st.top();
        }
        
        st.push(i);
    }

    return nsr;
}
    
vector<int> nsol(vector<int> arr, int n){
    vector<int> nsl(n,0);

    stack<int> st;

    for(int i=0; i<n; i++){
        int ele=arr[i];

        while(st.size()!=0 && arr[st.top()]>=ele){
            st.pop();
        }

        if(st.size()==0){
            nsl[i]=-1;
        } else {
            nsl[i]=st.top();
        }
        
        st.push(i);
    }

    return nsl;
}
    
    int largestRectangleArea(vector<int>& heights) {
        
        vector<int> nsl = nsol(heights,heights.size());
        vector<int> nsr = nsor(heights,heights.size());
        
        int maximum = -(int)1e9;
        for(int i=0; i<heights.size(); i++){
            int area = (nsr[i] - nsl[i] - 1)*heights[i];
            maximum = max(maximum,area);
            
        }
        
        return maximum;
        
    }
};