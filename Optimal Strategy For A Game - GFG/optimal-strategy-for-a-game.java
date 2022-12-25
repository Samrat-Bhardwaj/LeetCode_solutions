//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class OptimalStrategy
{
    public static void main (String[] args) {
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total number of testcases
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            //taking number of elements
            int n = sc.nextInt();
            int arr[] = new int[n];
            
            //inserting the elements
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
                
           //calling the countMaximum() method of class solve
           System.out.println(new solve().countMaximum(arr, n)); 
        }
    }
    
    
}
// } Driver Code Ends



class solve
{
    //Function to find the maximum possible amount of money we can win.
    public static int solve_tab(int[] arr, int i, int j, int[][] dp){
        int n = arr.length;
        for(int diag=0; diag<n; diag++){
            for(i=0,j=diag; j<n; i++,j++){
                if(i+1 == j){
                    dp[i][j] = Math.max(arr[i],arr[j]);
                    continue;
                }
        
                if(i==j){
                    dp[i][j] = arr[i];
                    continue;
                }
        
                int ans = 0;
                int takeFirst = arr[i] + Math.min(dp[i+2][j],dp[i+1][j-1]); //Math.min(solve_memo(arr,i+2,j,dp),solve_memo(arr,i+1,j-1,dp));
                int takeLast = arr[j] + Math.min(dp[i+1][j-1],dp[i][j-2]);  //Math.min(solve_memo(arr,i+1,j-1,dp),solve_memo(arr, i, j-2,dp));
        
                ans = Math.max(takeFirst, takeLast);
        
                dp[i][j] = ans;
            }
        }

        return dp[0][n-1];
    }
    static long countMaximum(int arr[], int n)
    {
        // Your code here
        // int n = arr.length;
        int[][] memo = new int[n][n];
        // return solve_rec(arr,0,n-1);
        // return solve_memo(arr,0,n-1,memo);
        return solve_tab(arr, 0, n-1, memo);
    }
}
