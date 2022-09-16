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

// leetcode 85================================================================

int maximalRectangle(vector<vector<char>>& matrix) {
    int m=matrix[0].size();
    int area=0;
    
    vector<int> heights(m,0);

    for(int i=0; i<matrix.size(); i++){
        for(int j=0; j<m; j++){
            if(matrix[i][j]=='0'){
                heights[j]=0;
            } else {
                heights[j]++;
            }
        }

        area=max(area,largestRectangleArea(heights));
    }        

    return area;
}
};