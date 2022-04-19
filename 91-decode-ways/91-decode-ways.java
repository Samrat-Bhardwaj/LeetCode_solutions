class Solution {
    public int rec(String str, int idx,int[] memo){
        if(idx==str.length()){
            return memo[idx]=1;
        }
        
        if(str.charAt(idx)=='0') return 0;
        
        if(memo[idx]!=-1) return memo[idx];
        // taking one char
        int ans=rec(str,idx+1,memo);
        
        // taking 2 char at a time
        if(idx+2<=str.length()){
            String sub=str.substring(idx,idx+2);
            if(Integer.parseInt(sub)<=26){
                ans+=rec(str,idx+2,memo);
            }
        }
        
        return memo[idx]=ans;
    }
    
    public int tab(String str){
        int n=str.length();
        
        int[] dp=new int[n+1];
        
        for(int idx=n; idx>=0; idx--){
            if(idx==str.length()){
                dp[idx]=1;
                continue;
            }

            if(str.charAt(idx)=='0'){
                dp[idx]=0;
                continue;
            }

            // if(memo[idx]!=-1) return memo[idx];
            // taking one char
            int ans=dp[idx+1];//rec(str,idx+1,memo);

            // taking 2 char at a time
            if(idx+2<=str.length()){
                String sub=str.substring(idx,idx+2);
                if(Integer.parseInt(sub)<=26){
                    ans+=dp[idx+2];//rec(str,idx+2,memo);
                }
            }

            dp[idx]=ans;
        }
        
        return dp[0];
    }
    
    public int numDecodings(String s) {
//         int[] memo=new int[s.length()+1];
        
//         Arrays.fill(memo,-1);
//         return rec(s,0,memo);
        
        return tab(s);
    }
}