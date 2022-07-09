// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String inline[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(inline[0]);
            int m = Integer.parseInt(inline[1]);
            String inline1[] = in.readLine().trim().split("\\s+");
            int M[][] = new int[n][m];
            for(int i = 0;i < n*m;i++){
                M[i/m][i%m] = Integer.parseInt(inline1[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.maxGold(n, m, M));
        }
    }
} // } Driver Code Ends


//User function Template for Java

class Solution{
    public static int tab(int[][] gold, int n, int m){
        int[][] dp=new int[n][m];

        for(int j=m-1; j>=0; j--){
            for(int i=0; i<n; i++){
                if(j==m-1){
                    dp[i][j]=gold[i][j];
                    continue;
                }
                
                //if(dp[i][j]!=0) return dp[i][j];
                
                int ans=0;
                if(i-1>=0)
                    ans=Math.max(ans,dp[i-1][j+1]);//Math.max(ans,rec(i-1,j+1,gold,n,m,dp));
                
                ans=Math.max(ans,dp[i][j+1]);//Math.max(ans,rec(i,j+1,gold,n,m,dp));
                
                if(i+1<n)
                    ans=Math.max(ans,dp[i+1][j+1]);//Math.max(ans,rec(i+1,j+1,gold,n,m,dp));
                    
                dp[i][j]=ans + gold[i][j];
            }
        }

        int max_gold=0;
        for(int i=0; i<n; i++){
            max_gold=Math.max(max_gold,dp[i][0]);
        }

        return max_gold;
    }
    
    static int maxGold(int n, int m, int gold[][])
    {
        return tab(gold,n,m);
    }
}