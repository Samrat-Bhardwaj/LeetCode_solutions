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
    static int rec(int i, int j, int[][] gold, int n, int m,int[][] dp){
        if(j==m-1){
            return dp[i][j]=gold[i][j];
        }
        
        if(dp[i][j]!=0) return dp[i][j];
        
        int ans=0;
        if(i-1>=0)
            ans=Math.max(ans,rec(i-1,j+1,gold,n,m,dp));
        
        ans=Math.max(ans,rec(i,j+1,gold,n,m,dp));
        
        if(i+1<n)
            ans=Math.max(ans,rec(i+1,j+1,gold,n,m,dp));
            
        return dp[i][j]=ans + gold[i][j];
    }
    
    static int maxGold(int n, int m, int gold[][])
    {
        int ans=0;
        
        int[][] dp=new int[n][m];
        
        for(int i=0; i<n; i++){
            int curr_ans=rec(i,0,gold,n,m,dp);
            ans=Math.max(ans,curr_ans);
        }
        
        return ans;
    }
}