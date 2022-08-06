class Solution {
public:
    int minimumMountainRemovals(vector<int>& nums) {
         int n=nums.size();

        vector<int> dp_lr(n,0);


        for(int i=0; i<n; i++){
            dp_lr[i]=1;

            for(int j=i-1; j>=0; j--){
                if(nums[j]<nums[i]){
                    dp_lr[i]=max(dp_lr[i],dp_lr[j]+1);
                }
            }
        }

        vector<int> dp_rl(n,0);

        for(int i=n-1; i>=0; i--){
            dp_rl[i]=1;

            for(int j=i+1; j<n; j++){
                if(nums[j]<nums[i]){
                    dp_rl[i]=max(dp_rl[i],dp_rl[j]+1);
                }
            }
        }

        int ans=0;

        for(int i=1; i<n-1; i++){
            if(dp_lr[i]==1 || dp_rl[i]==1){
                continue;
            }
            
            ans=max(ans,dp_lr[i]+dp_rl[i]-1);
        }

        return n-ans;
    }
};