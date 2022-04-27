// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDeletions(Arr,n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java
class Solution
{
	public int minDeletions(int nums[], int n) 
	{ 
        
        int[] dp=new int[n];
        
        int lis=0;
        
        for(int i=0; i<n; i++){
            dp[i]=1;
            
            for(int j=i-1; j>=0; j--){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            
            lis=Math.max(lis,dp[i]);
        }
        
        
        return n-lis;
	} 
}