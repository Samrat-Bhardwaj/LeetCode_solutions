// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function Template for Java

class Solution{
    int longSubarrWthSumDivByK(int a[], int n, int k)
    {
        int[] rem_index=new int[k];
        
        Arrays.fill(rem_index,-2);
        
        int csum=0;
        int ans=0;
        
        rem_index[0]=-1;
        for(int i=0; i<n; i++){
            csum+=a[i];
            
            int rem=csum%k;
            
            if(rem<0){
                rem+=k;
            }
            
            if(rem_index[rem]!=-2){
                int len=i-rem_index[rem];
                ans=Math.max(ans,len);
            } else {
                rem_index[rem]=i;
            }
        }
        
        return ans;
    }
 
}


// { Driver Code Starts.

// Driver class
class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    String line1 = br.readLine();
		    String[] element = line1.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    int K = Integer.parseInt(element[1]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		   
		    int res = obj.longSubarrWthSumDivByK(arr, sizeOfArray, K);
		    
		    System.out.println(res);
		    
		    
		}
	}
}


  // } Driver Code Ends