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

   public int minCut_tab(String str, int SI, boolean[][] isPallindrome, int[] dp){
        for(int si=str.length()-1; si>=0; si--){
            if(isPallindrome[si][str.length()-1]){
                dp[si]=0;
                continue;
            }
    
            int ans=(int)(1e9);
            for(int cut=si; cut<str.length(); cut++){
                if(cut+1<str.length() && isPallindrome[si][cut]){
                    ans=Math.min(ans,dp[cut+1]+1);//ans=Math.min(ans,minCut_memo(str,cut+1,isPallindrome,dp)+1);
                }
            }
    
            dp[si]=ans;
        }

        return dp[SI];
    }

    public int minCut(String s) {
        boolean[][] isPallindrome=makeIsPallindrome(s);
        int[] dp=new int[s.length()];

        Arrays.fill(dp,(int)(1e8));

        // return minCut_memo(s, 0, isPallindrome, dp);
        return minCut_tab(s, 0, isPallindrome, dp);
    }
}