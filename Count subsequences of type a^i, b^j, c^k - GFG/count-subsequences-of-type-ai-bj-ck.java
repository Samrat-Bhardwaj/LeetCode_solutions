// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner (System.in);
		int t = Integer.parseInt(sc.next());
		
		while(t>0)
		{
		    String s = sc.next();
		    
		    Solution T = new Solution();
		    System.out.println(T.fun(s));
		    
		    t--;
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int fun(String s)
    {
        // Write your code here
        long sa=0;
        long sab=0;
        long sabc=0;
        long mod=(long)1e9+7;
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='a'){
                sa=1+2*sa;
            } else if(s.charAt(i)=='b'){
                sab=sa+2*sab;
            } else {
                sabc=sab+2*sabc;
            }
            
            sa=sa%mod;
            sab=sab%mod;
            sabc=sabc%mod;
        }
        
        return (int)sabc;
    }
}