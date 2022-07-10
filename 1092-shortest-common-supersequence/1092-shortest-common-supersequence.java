class Solution {
    public static String tab_lcs(String text1, String text2, int N, int M){
        int[][] dp=new int[N+1][M+1];
        String[][] sdp=new String[N+1][M+1];

        for(int n=0; n<=N; n++){
            for(int m=0; m<=M; m++){
                if(n==0 || m==0){
                    dp[n][m]=0;
                    sdp[n][m]="";
                    continue;
                }
        
                //if(dp[n][m]!=-1) return dp[n][m];
        
                if(text1.charAt(n-1)==text2.charAt(m-1)){
                    dp[n][m]=dp[n-1][m-1]+1;//memo_lcs(text1, text2, n-1, m-1, dp) + 1;
                    sdp[n][m]=sdp[n-1][m-1]+text1.charAt(n-1);
                } else {
                    if(dp[n-1][m]>dp[n][m-1]){
                        dp[n][m]=dp[n-1][m];
                        sdp[n][m]=sdp[n-1][m];
                    } else {
                        dp[n][m]=dp[n][m-1];
                        sdp[n][m]=sdp[n][m-1];
                    }
                    // dp[n][m]=Math.max(dp[n-1][m],dp[n][m-1]);//Math.max(memo_lcs(text1,text2,n-1,m,dp), memo_lcs(text1, text2, n, m-1, dp));
                }
            }
        }
        
        return sdp[N][M];
    }

    public String shortestCommonSupersequence(String str1, String str2) {
        String lcs=tab_lcs(str1,str2,str1.length(),str2.length());
        
        int i=0; int j=0;
        int k=0;
        
        String ans="";
        
        while(k<lcs.length()){
            while(str1.charAt(i)!=lcs.charAt(k)){
                ans+=str1.charAt(i);
                i++;
            }
            
            while(str2.charAt(j)!=lcs.charAt(k)){
                ans+=str2.charAt(j);
                j++;
            }
            
            ans+=lcs.charAt(k);
            i++;
            j++;
            k++;
        }
        
        ans+=str1.substring(i);
        ans+=str2.substring(j);
        
        return ans;
    }
}