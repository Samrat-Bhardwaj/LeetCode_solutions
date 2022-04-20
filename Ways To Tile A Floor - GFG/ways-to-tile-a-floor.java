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
    
    public static long tab_better(int n){
        if(n==1) return 1;
        if(n==2) return 2;
        
        long a=1; // n==0
        long b=1; // n==1
        
        for(int i=2; i<=n; i++){
            long c=a+b; // ans for i is equal sum of ans for i-1 and ans for i-2
            
            a=b;
            b=c;
            
            a=a%mod;
            b=b%mod;
        }
        
        return b;
    }
    
    static Long numberOfWays(int N) {
        long[] memo=new long[N+1];
        // return rec(N,memo);
        return tab_better(N);
    }
};