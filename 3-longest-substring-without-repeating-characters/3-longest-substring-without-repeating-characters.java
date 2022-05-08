class Solution {
    public int lengthOfLongestSubstring(String s) {
        int si=0;
        int ei=0;
        
        // correct window -> {si,ei-1}
        
        int[] fre=new int[128];
        int count=0; // count of repeating characters
        int ans=0;
        
        while(ei<s.length()){
            if(fre[s.charAt(ei)]==1){
                count++;
            }
            
            fre[s.charAt(ei)]++;
            ei++;
            
            while(count>0){ // correct the window
                if(fre[s.charAt(si)]==2){
                    count--;
                }
                
                fre[s.charAt(si)]--;
                si++;
            }
            
            if(ans<(ei-si)){
                ans=ei-si;
            }
        }
        
        return ans;
    }
}