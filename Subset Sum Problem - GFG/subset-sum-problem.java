//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public static int isSubsetSum_memo(int idx, int[] arr, int target, int[][] dp){
        if(target == 0){
            return dp[idx][target] = 1;
        }

        if(idx == arr.length){
            return dp[idx][target] = 0; 
        }

        if(dp[idx][target]!=-1) return dp[idx][target];

        int pick = 0;

        if(target - arr[idx] >=0)
            pick = isSubsetSum_memo(idx+1, arr, target-arr[idx], dp);

        int notPick = isSubsetSum_memo(idx+1, arr, target, dp);

        return dp[idx][target] = pick | notPick ;
    }

    static Boolean isSubsetSum(int N, int arr[], int target){
        int[][] dp = new int[N+1][target+1];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        // return isSubsetSum_rec(0, arr, target);
        int ans =  isSubsetSum_memo(0, arr, target,dp);
        return ans == 1  ? true : false;
    }
}