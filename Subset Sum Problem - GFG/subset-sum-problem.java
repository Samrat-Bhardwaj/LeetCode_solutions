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
    public static boolean isSubsetSum_tab(int idx, int[] arr, int Target, boolean[][] dp){
        for(idx = arr.length; idx>=0; idx--){
            for(int target = 0; target<=Target; target++){
                if(target == 0){
                    dp[idx][target] = true;
                    continue;
                }
        
                if(idx == arr.length){
                    dp[idx][target] = false; 
                    continue;
                }
        
                boolean pick = false;
        
                if(target - arr[idx] >=0)
                    pick = dp[idx+1][target-arr[idx]]; //isSubsetSum_memo(idx+1, arr, target-arr[idx], dp);
        
                boolean notPick = dp[idx+1][target];  //isSubsetSum_memo(idx+1, arr, target, dp);
        
                dp[idx][target] = pick | notPick ;
            }
        }

        return dp[0][Target];
    }

    static Boolean isSubsetSum(int N, int arr[], int target){
        // int[][] dp = new int[N+1][target+1];
        // for(int[] d:dp){
        //     Arrays.fill(d,-1);
        // }
        // return isSubsetSum_rec(0, arr, target);
        // int ans =  isSubsetSum_memo(0, arr, target,dp);
        // return ans == 1  ? true : false;
        return isSubsetSum_tab(0, arr, target, new boolean[N+1][target+1]);
    }
}