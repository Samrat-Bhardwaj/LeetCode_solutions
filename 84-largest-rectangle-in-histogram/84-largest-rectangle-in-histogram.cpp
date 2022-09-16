class Solution {
public:
int largestRectangleArea(vector<int>& heights) {
    int area=0;
    int n=heights.size();
    stack<int> st;
    st.push(-1);

    for(int i=0; i<n; i++){
        while(st.top()!=-1 && heights[st.top()]>=heights[i]){
            int h=heights[st.top()];
            st.pop();

            int width = i - st.top() - 1;
            area=max(area,h*width);
        }
        st.push(i);
    }

    while(st.top()!=-1){
        int h=heights[st.top()];
        st.pop();

        int w=n-st.top()-1;
        area=max(area,h*w);
    }

    return area;
}
};