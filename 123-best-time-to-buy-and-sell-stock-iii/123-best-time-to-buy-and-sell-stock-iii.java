class Solution {
    public int maxProfit(int[] prices) {
        int dpi10=0;
        int dpi20=0;
        int dpi11=-(int)(1e9);
        int dpi21=-(int)(1e9);
        
        for(int i=0; i<prices.length; i++){
            int p=prices[i];
            
            dpi20=Math.max(dpi20,dpi21+p);
            dpi21=Math.max(dpi21,dpi10-p);
            dpi10=Math.max(dpi10,dpi11+p);
            dpi11=Math.max(dpi11,0-p);
        }
        
        return dpi20;
    }
}