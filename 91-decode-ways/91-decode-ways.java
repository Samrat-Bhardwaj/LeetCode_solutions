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
    
    public int numDecodings(String s) {
        int[] memo=new int[s.length()+1];
        Arrays.fill(memo,-1);
        return rec(s,0,memo);
    }
}