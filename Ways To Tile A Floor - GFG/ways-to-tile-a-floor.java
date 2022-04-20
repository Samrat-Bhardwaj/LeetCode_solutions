// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.numberOfWays(N));
        }
    }
}// } Driver Code Ends


class Solution {
    static long mod=(long)(1e9+7);
    
    static long rec(int n,long[] memo){
        if(n==0) return 1;
        
        long ans=0;
        if(memo[n]!=0) return memo[n];
        
        // placing vertically
        ans=rec(n-1,memo);
        
        // placing horizontally
        if(n-2>=0){
            ans+=rec(n-2,memo);
        }
        
        return memo[n]=ans%mod;
    }
    
    public static long tab(int n){
        long[] dp=new long[n+1];
        dp[0]=1;
        
        for(int i=1; i<=n; i++){
            long ans=dp[i-1];
            if(i-2>=0)
                ans+=dp[i-2];
                
            dp[i]=ans%mod;
        }
        
        return dp[n];
    }
    
    static Long numberOfWays(int N) {
        long[] memo=new long[N+1];
        // return rec(N,memo);
        return tab(N);
    }
};