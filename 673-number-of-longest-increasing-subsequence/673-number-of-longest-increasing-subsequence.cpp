class Solution {
public:
    int findNumberOfLIS(vector<int>& nums) {
    int n=nums.size();

    vector<int> dp(n,0);        
    vector<int> count(n,0);   

    int maxLen=0;
    int maxCount=0;

    for(int i=0; i<n; i++){
        dp[i]=1;
        count[i]=1;

        for(int j=i-1; j>=0; j--){
            if(nums[j] < nums[i]){
                if(dp[j]+1 > dp[i]){
                    dp[i]=dp[j]+1;
                    count[i]=count[j];
                } else if(dp[j]+1 == dp[i]){
                    count[i]+=count[j];
                }
            }
        }

        if(dp[i]>maxLen){
            maxLen=dp[i];
            maxCount=count[i];
        } else if(maxLen == dp[i]){
            maxCount+=count[i];
        }
    }     

    return maxCount;
}
};