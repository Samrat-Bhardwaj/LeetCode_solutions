class Solution {
    public int MatchStrings(String s, String p,int n, int m,int[][] dp){
        if(n==0 || m==0){
            if(n==0 && m==0){
                return dp[n][m]=1;
            } else if(m==1 && p.charAt(m-1)=='*'){
                return dp[n][m]=1;
            } else {
                return dp[n][m]=0;
            }
        }
        
        if(dp[n][m]!=-1) return dp[n][m];
        
        if(p.charAt(m-1)=='?'){
            return dp[n][m]=MatchStrings(s,p,n-1,m-1,dp);
        } else if(p.charAt(m-1)=='*'){
            int ans1=MatchStrings(s,p,n-1,m,dp);
            int ans2=MatchStrings(s,p,n,m-1,dp);
            
            if(ans1==1 || ans2==1){
                return dp[n][m]=1;
            } else {
                return dp[n][m]=0;
            }
        } else if(s.charAt(n-1)==p.charAt(m-1)){
            return dp[n][m]=MatchStrings(s,p,n-1,m-1,dp);
        } else {
            return dp[n][m]=0;
        }
    }
    
    public boolean isMatch(String s, String p) {
        StringBuilder sb=new StringBuilder();
        if(p.length()==0){
            return s.length()==0;
        }
        
        int i=1;
        sb.append(p.charAt(0));
        
        while(i<p.length()){
            while(i<p.length() && p.charAt(i)=='*' && p.charAt(i-1)==p.charAt(i)){
                i++;
            }
            
            if(i<p.length())
                sb.append(p.charAt(i));
            
            i++;
        }
        
        p=sb.toString();
        
        int n=s.length();
        int m=p.length();
        
        int[][] dp=new int[n+1][m+1];
        
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        
        int ans=MatchStrings(s,p,n,m,dp);
        
        return ans==1;
    }
}