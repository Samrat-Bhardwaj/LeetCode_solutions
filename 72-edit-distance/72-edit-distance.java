class Solution {
    public int rec(String w1, String w2, int n, int m){
        if(n==0) return m;
        if(m==0) return n;
        
        if(w1.charAt(n-1)==w2.charAt(m-1)){
            return rec(w1,w2,n-1,m-1);
        }
        
        int insert=rec(w1,w2,n,m-1);
        int delete=rec(w1,w2,n-1,m);
        int replace=rec(w1,w2,n-1,m-1);
        
        return Math.min(insert,Math.min(delete,replace))+1;
    }
    
    public int rec_memo(String w1, String w2, int n, int m,int[][] memo){
        if(n==0 || m==0){
            return memo[n][m]= (n==0) ? m : n;
        }
        
        if(memo[n][m]!=0) return memo[n][m];
        
        if(w1.charAt(n-1)==w2.charAt(m-1)){
            return memo[n][m]=rec_memo(w1,w2,n-1,m-1,memo);
        }
        
        int insert=rec_memo(w1,w2,n,m-1,memo);
        int delete=rec_memo(w1,w2,n-1,m,memo);
        int replace=rec_memo(w1,w2,n-1,m-1,memo);
        
        return memo[n][m]=Math.min(insert,Math.min(delete,replace))+1;
    }
    
    public int tab(String w1, String w2, int n, int m){
        int[][] dp=new int[n+1][m+1];
        
        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){
                if(i==0){
                    dp[i][j]=j;
                } else if(j==0){
                    dp[i][j]=i;
                } else if(w1.charAt(i-1)==w2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                } else {
                    int insert=dp[i][j-1];
                    int delete=dp[i-1][j];
                    int replace=dp[i-1][j-1];
                    
                    dp[i][j]=Math.min(insert,Math.min(delete,replace))+1;
                }
            }
        }
        
        return dp[n][m];
    }
    
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        
        int[][] memo=new int[n+1][m+1];
        // return rec_memo(word1,word2,n,m,memo);
        return tab(word1,word2,n,m);
    }
}