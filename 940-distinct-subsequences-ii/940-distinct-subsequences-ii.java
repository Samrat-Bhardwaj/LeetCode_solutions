class Solution {
    public int distinctSubseqII(String s) {
        int[] loc=new int[26];
        Arrays.fill(loc,-1);
        
        int n=s.length();
        long[] dp=new long[n+1];
        
        dp[0]=1l;
        long mod=(long)(1e9+7);
        
        for(int i=1; i<=n; i++){
            dp[i]=(2*dp[i-1]);
            
            char ch=s.charAt(i-1);
            
            int lastIdx=loc[ch-'a'];
            if(lastIdx!=-1){
                dp[i]=((dp[i]%mod)-(dp[lastIdx-1]%mod)+mod)%mod;
            }
            
            loc[ch-'a']=i;
            dp[i]=dp[i]%mod;
        }
        
        return (int)(dp[n]-1);
    }
}