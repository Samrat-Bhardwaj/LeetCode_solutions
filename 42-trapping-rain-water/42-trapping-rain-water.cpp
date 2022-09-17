class Solution {
public:
    int trap(vector<int>& height) {
        int n=height.size();
        
        vector<int> left(n,0);
        vector<int> right(n,0);
        
        int msf=0;
        for(int i=0; i<n; i++){
            left[i]=max(msf,height[i]);
            msf=left[i];
        }
        
        msf=0;
        for(int i=n-1; i>=0; i--){
            right[i]=max(msf,height[i]);
            msf=right[i];
        }
        
        int ans=0;
        for(int i=0; i<n; i++){
            int mlr=min(left[i],right[i]);
            
            ans+=(mlr-height[i]);
        }
        
        return ans;
    }
};