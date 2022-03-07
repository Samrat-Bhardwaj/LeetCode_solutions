// { Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n)
    {
        HashMap<Integer,Integer> map=new HashMap<>();
        
        int csum=0;
        int ans=0;
        
        map.put(csum,-1);
        
        for(int i=0; i<n; i++){
            csum+=arr[i];
            
            if(map.containsKey(csum)){
                int len=i-map.get(csum);
                ans=Math.max(ans,len);
            } else {
                map.put(csum,i);
            }
        }
        
        return ans;
    }
}