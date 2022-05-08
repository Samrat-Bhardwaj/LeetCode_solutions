// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String str = br.readLine();
            
            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public int findSubString( String s) {
        int need=0;
        int[] requirements=new int[128];
        
        for(int i=0; i<s.length(); i++){
            if(requirements[s.charAt(i)]==0){
                need++;
                requirements[s.charAt(i)]=1;
            }
        }
        
        int si=0;
        int ei=0;
        
        int min_len=(int)(1e9);
        
        while(ei<s.length()){
            if(requirements[s.charAt(ei)]>0){
                need--;
            }
            
            requirements[s.charAt(ei)]--;
            ei++;
            
            while(need==0){
                if(min_len>(ei-si)){
                    min_len=ei-si;
                }
                
                if(requirements[s.charAt(si)]==0){
                    need++;
                }
                
                requirements[s.charAt(si)]++;
                si++;
            }
        }
        
        return min_len;
    }
}