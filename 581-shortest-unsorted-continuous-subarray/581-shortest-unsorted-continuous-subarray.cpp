class Solution {
public:
    int findUnsortedSubarray(vector<int>& nums) {
        int mi=(int)1e5;
        int ma=-(int)1e5;
        
        bool flag=false;
        for(int i=0; i<nums.size()-1; i++){
            if(nums[i]>nums[i+1]){
                
                flag=true;
            }
            if(flag)
                mi=min(mi,nums[i+1]);
        }
        
        flag=false;
        for(int i=nums.size()-1; i>0; i--){
            if(nums[i-1]>nums[i]){
                flag=true;
            }
            if(flag)
                ma=max(ma,nums[i-1]);
        }
        int l=0,r=-1;
        for(int i=0; i<nums.size(); i++){
            if(nums[i]>mi){
                l=i;
                break;
            }
        }
        for(int i=nums.size()-1; i>=0; i--){
            if(nums[i]<ma){
                r=i;
                break;
            }
        }
        
        return r-l+1>0 ? r-l+1 : 0;
    }
};