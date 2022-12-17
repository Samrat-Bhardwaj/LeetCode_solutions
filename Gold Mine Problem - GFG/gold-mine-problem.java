//{ Driver Code Starts
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
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    public static int getMax_memo(int[][] mine, int i, int j, int[][] dp){
        if(j==mine[0].length-1){
            return dp[i][j] = mine[i][j];
        }

        if(dp[i][j]!=0) return dp[i][j];
        
        int up = 0;
        int same = 0;
        int down = 0;

        if(i-1 >= 0){
            up = getMax_memo(mine, i-1, j+1,dp);
        }

        same = getMax_memo(mine, i, j+1,dp);

        if(i+1<mine.length){
            down = getMax_memo(mine, i+1, j+1,dp);
        }

        int ans = mine[i][j] + Math.max(up,Math.max(same,down));

        return dp[i][j] = ans;
    }

    static int maxGold(int n, int m, int M[][])
    {
        int ans = 0;
        int[][] dp = new int[n][m];
        // for(int i=0; i<n; i++){
        //     int gold = getMax_rec(M,i,0);
        //     ans = Math.max(gold,ans);
        // }

        for(int i=0; i<n; i++){
            int gold = getMax_memo(M,i,0,dp);
            ans = Math.max(gold,ans);
        }

        return ans;
    }
}