class Solution {
    public int maximumProduct(int[] arr) {
        int n=arr.length;
        
        int[] lmax=new int[n];
        int[] lmin=new int[n];

        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            max=Math.max(arr[i],max);
            min=Math.min(arr[i],min);

            lmax[i]=max;
            lmin[i]=min;
        }

        int[] rmax=new int[n];
        int[] rmin=new int[n];

        max=Integer.MIN_VALUE;
        min=Integer.MAX_VALUE;

        for(int i=n-1; i>=0; i--){
            max=Math.max(arr[i],max);
            min=Math.min(arr[i],min);

            rmax[i]=max;
            rmin[i]=min;
        }

        int ans=Integer.MIN_VALUE;

        for(int i=1; i<n-1; i++){
            int a=Math.max(lmax[i-1]*arr[i]*rmax[i+1],lmin[i-1]*arr[i]*rmin[i+1]);

            int b=Math.max(lmax[i-1]*arr[i]*rmin[i+1],lmin[i-1]*arr[i]*rmax[i+1]);

            int curr_ans=Math.max(a,b);

            ans=Math.max(ans,curr_ans);
        }

        return ans;
    }
}