class Solution {
    public boolean[][] makeIsPallindrome(String str){
        int n=str.length();

        boolean[][] dp=new boolean[n][n];

        for(int diag=0; diag<n; diag++){
            for(int i=0,j=diag; j<n; i++,j++){
                if(diag==0){ // length 1 (i==j)
                    dp[i][j]=true;
                } else if(diag==1){ // length 2;
                    dp[i][j]= (str.charAt(i)==str.charAt(j));
                } else {
                    if(str.charAt(i)==str.charAt(j)){
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
            }
        }

        return dp;
    }

    public int minCut_memo(String str,int si, boolean[][] isPallindrome, int[] dp){
        if(isPallindrome[si][str.length()-1]){
            return dp[si]=0;
        }

        if(dp[si]!=-1){
            return dp[si];
        }

        int ans=(int)(1e9);
        for(int cut=si; cut<str.length(); cut++){
            if(isPallindrome[si][cut]){
                ans=Math.min(ans,minCut_memo(str,cut+1,isPallindrome,dp)+1);
            }
        }

        return dp[si]=ans;
    }
    
    public int minCut(String s) {
        boolean[][] isPallindrome=makeIsPallindrome(s);
        int[] dp=new int[s.length()];

        Arrays.fill(dp,-1);

        return minCut_memo(s, 0, isPallindrome, dp);
    }
}