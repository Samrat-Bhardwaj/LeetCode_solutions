class Solution {
     public int lcs(String text1, String text2, int n, int m){
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
    
    public int minDistance(String word1, String word2) {
        return word1.length() + word2.length()- 2*lcs(word1,word2,word1.length(),word2.length());
    }
}