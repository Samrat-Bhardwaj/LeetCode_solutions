//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    public long combination_memo(int[] coins, int idx, int tar, long[][] dp){
        if(tar==0){
            return dp[idx][tar]=1;
        }

        if(dp[idx][tar]!=-1) return dp[idx][tar];

        long ans = 0;
        for(int j=idx; j<coins.length; j++){
            if(tar - coins[j]>=0){
                ans += combination_memo(coins, j, tar - coins[j],dp);
            }
        }

        return dp[idx][tar]=ans;
    }

    public long count(int coins[], int N, int target) {
        long[][] dp = new long[N][target+1];
        for(long[] d:dp){
            Arrays.fill(d,-1);
        }
        // return combination_rec(coins,0,target);
        return combination_memo(coins, 0, target,dp);
    }
}