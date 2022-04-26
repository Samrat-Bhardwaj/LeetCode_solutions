class Solution {
    public int rec(String text1, String text2, int n, int m){
        if(n==0) return 0;
        if(m==0) return 0;
        
        if(text1.charAt(n-1)==text2.charAt(m-1)){
            return rec(text1,text2,n-1,m-1)+1;
        } else {
            return Math.max(rec(text1,text2,n-1,m),rec(text1,text2,n,m-1));
        }
    }
    
    public int rec_memo(String text1, String text2, int n, int m,int[][] memo){
        if(n==0 || m==0){
            return 0;
        }
        
        if(memo[n][m]!=0) return memo[n][m];
        
        if(text1.charAt(n-1)==text2.charAt(m-1)){
            return memo[n][m]=rec_memo(text1,text2,n-1,m-1,memo)+1;
        } else {
            return memo[n][m]=Math.max(rec_memo(text1,text2,n-1,m,memo),rec_memo(text1,text2,n,m-1,memo));
        }
    }
    
    public int tab2(String text1, String text2, int n, int m){
        int[][] dp=new int[n+1][m+1];
        
        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                } else if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                } else {
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        
        return dp[n][m];
    }
    
    public int tab(String text1, String text2, int N, int M){
        int[][] dp=new int[N+1][M+1];
        
        for(int n=0; n<=N; n++){
            for(int m=0; m<=M; m++){
                if(n==0 || m==0){
                    dp[n][m]=0;
                    continue;
                }

                if(text1.charAt(n-1)==text2.charAt(m-1)){
                    dp[n][m]=dp[n-1][m-1]+1; //rec_memo(text1,text2,n-1,m-1,memo)+1;
                } else {
                    dp[n][m]=Math.max(dp[n-1][m],dp[n][m-1]);
                }
            }
        }
        
        return dp[N][M];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        
        // int[][] memo=new int[n+1][m+1];
                // return rec(text1,text2,n,m);
        // return rec_memo(text1,text2,n,m,memo);
        return tab2(text1,text2,n,m);
        
    }
}