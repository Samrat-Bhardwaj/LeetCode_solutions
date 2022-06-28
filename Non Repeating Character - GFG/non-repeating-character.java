// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String st = sc.next();
            
            char ans=new Solution().nonrepeatingCharacter(st);
            
            if(ans!='$')
            System.out.println(ans);
            else
            System.out.println(-1);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find the first non-repeating character in a string.
    static char nonrepeatingCharacter(String str){
        int n=str.length();

        int[] fre=new int[26];

        // storing frequencies of each character
        for(int i=0; i<n; i++){
            char ch=str.charAt(i);

            int idx=ch-'a';
            fre[idx]++;
        }

        for(int i=0; i<n; i++){
            char ch=str.charAt(i);

            int idx=ch-'a';

            if(fre[idx]==1){
                return ch;
            }
        }

        return '$';
    }
}

