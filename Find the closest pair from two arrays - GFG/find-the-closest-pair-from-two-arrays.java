// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String[] element = br.readLine().split(" ");
		    int N = Integer.parseInt(element[0]);
		    int M = Integer.parseInt(element[1]);
		    int arr [] = new int[N];
		    int brr [] = new int[M];
		    String[] elements = br.readLine().split(" ");
		    for(int i=0; i<N; i++)
		        arr[i] = Integer.parseInt(elements[i]);
		        
		    String[] ele = br.readLine().split(" ");
		    for(int i=0; i<M; i++)
		        brr[i] = Integer.parseInt(ele[i]);
		    
		    int X = Integer.parseInt(br.readLine());
		    
		    Solution obj = new Solution();
		    ArrayList<Integer> ans;
		    ans = obj.printClosest(arr, brr, N, M, X);
		    System.out.println(Math.abs(ans.get(0) + ans.get(1) - X));
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    // Function for finding maximum and value pair
    public static ArrayList<Integer> printClosest (int arr1[], int arr2[], int n1, int n2, int tar) {
        int diff=Integer.MAX_VALUE;
        // int n2=arr2.length;
        
        int x1=-1;
        int x2=-1;
        
        int l=0;
        int r=n2-1;

        while(l<arr1.length && r>=0){
            int csum=arr1[l] + arr2[r];
            
            int curr_diff= Math.abs(csum-tar);
            
            if(curr_diff < diff){
                 x1=arr1[l];
                x2=arr2[r];

                diff=curr_diff;
            }
            
            if(csum>tar){
                r--;
            } else {
                l++;
            }
        }
        
        ArrayList<Integer> al=new ArrayList<>();
        
        al.add(x1);
        al.add(x2);
        
        return al;
    }
}