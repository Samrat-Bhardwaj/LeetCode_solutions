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

    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        
        int[][] memo=new int[n+1][m+1];
                // return rec(text1,text2,n,m);
        return rec_memo(text1,text2,n,m,memo);
        
    }
}