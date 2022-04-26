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
    
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        
        int[][] memo=new int[n+1][m+1];
        return rec_memo(word1,word2,n,m,memo);
    }
}