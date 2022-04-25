class Solution {
    public int rec(String s, int si, int ei){
        if(si==ei){
            return 1;
        }
        
        if(si>ei){
            return 0;
        }
        
        if(s.charAt(si)==s.charAt(ei)){
            return rec(s,si+1,ei-1)+2;
        } else {
            return Math.max(rec(s,si+1,ei),rec(s,si,ei-1));
        }
    }
    
    public int rec_memo(String s, int si, int ei,int[][] memo){
        if(si==ei){
            return memo[si][ei]=1;
        }
        
        if(si>ei){
            return 0;
        }
        
        if(memo[si][ei]!=0) return memo[si][ei];
        
        if(s.charAt(si)==s.charAt(ei)){
            return memo[si][ei]=rec_memo(s,si+1,ei-1,memo)+2;
        } else {
            return memo[si][ei]=Math.max(rec_memo(s,si+1,ei,memo),rec_memo(s,si,ei-1,memo));
        }
    }
    
    public int tab(String s){
        int n=s.length();
        
        int[][] dp=new int[n][n];
        
        for(int diag=0; diag<n; diag++){
            for(int i=0,j=diag; j<n; i++,j++){
                if(diag==0){ // when i is equal to j
                    dp[i][j]=1;
                } else if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]=dp[i+1][j-1]+2;
                } else {
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        
        return dp[0][n-1];
    }
    
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        // int[][] memo=new int[n][n];
        // return rec(s,0,s.length()-1);
        // return rec_memo(s,0,n-1,memo);
        return tab(s);
    }
}