class Solution {
public:
   int rec_memo(vector<int>& coins, int tar,int idx,vector<vector<int>>& dp){
     if(tar==0){
        return dp[idx][tar]=0;
    }

    if(idx==coins.size()){
        return dp[idx][tar]=(int)(1e9); 
    }

    if(dp[idx][tar]!=-1) return dp[idx][tar];

    int ans=(int)(1e9);

    for(int j=idx; j<coins.size(); j++){
        if(tar-coins[j]>=0){
            ans=min(ans,rec_memo(coins,tar-coins[j],j,dp)+1);
        }
    }

    return dp[idx][tar]=ans;
}

int coinChange(vector<int>& coins, int amount) {
    vector<vector<int>> dp(coins.size(),vector<int>(amount+1,-1));

     int ans=rec_memo(coins,amount,0,dp);     

     return ans==(int)(1e9) ? -1 : ans;   
}

};