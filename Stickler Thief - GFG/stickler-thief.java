//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum money the thief can get.
    public int findMax_tabulation(int idx, int[] arr, int[] memo){
        for(idx=arr.length; idx>=0; idx--){
            if(idx == arr.length){
                memo[idx]=0;
                continue;
            }
    
            int rob=arr[idx];
            int notRob=0;
    
            if(idx+2<=arr.length)
                rob += memo[idx+2];//findMax_memo(idx+2, arr,memo);
            
            notRob = memo[idx+1]; //findMax_memo(idx+1, arr,memo);
    
            int ans = Math.max(rob,notRob);
    
            memo[idx]=ans;
        }

        return memo[0];
    }

    public int FindMaxSum(int arr[], int n){
        int[] memo= new int[n+1];
        return findMax_tabulation(0, arr, memo);
        // return findMax_memo(0, arr,memo);
        // return findMax(0,arr);
    }
}