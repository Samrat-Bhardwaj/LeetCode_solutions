class Solution {
public:
    int trap(vector<int>& height) {
        int n=height.size();
        int ans=0;
        
        stack<int> st;
        
        for(int i=0; i<n; i++){
            while(st.size()!=0 && height[st.top()]<=height[i]){
                int h=height[st.top()];
                st.pop();
                
                if(st.size()==0) break;
                
                int w=i-st.top()-1;
                ans+=w*(min(height[i],height[st.top()])-h);
            }
            st.push(i);
        }
        
        return ans;
    }
};