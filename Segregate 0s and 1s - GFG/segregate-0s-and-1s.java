// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            new Solution().segregate0and1(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public void swap(int[] nums, int i, int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
    
    void segregate0and1(int[] nums, int n) {
        // code here
        int p1=-1;
        int p2=0;


        while(p2<nums.length){
            if(nums[p2]==0){
                p1++;
                swap(nums,p1,p2);
            }
            p2++;
        }
    }

}
