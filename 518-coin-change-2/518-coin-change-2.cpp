class Solution {
public:
    int change(int amount, vector<int>& coins) {
        vector<int> dp(amount+1);
        
        dp[0]=1;
        
        for(int ele:coins){
            for(int tar=0; tar<=amount; tar++){
                if(tar-ele >=0 ){
                    dp[tar]+=dp[tar-ele];
                }
            }
        }
        
        return dp[amount];
    }
};