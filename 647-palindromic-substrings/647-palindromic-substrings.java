class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        
        boolean[][] dp=new boolean[n][n];
        
        int count=0;
        
        for(int diag=0; diag<n; diag++){
            for(int i=0,j=diag; j<n; i++,j++){
                if(diag==0){ // length of substring =1;
                    dp[i][j]=true;
                } else if(diag==1){ // length of substring=2;
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j]=true;
                    }
                } else {
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
                
                if(dp[i][j]==true){
                    count++;
                }
            }
        }
        
        return count;
    }
}