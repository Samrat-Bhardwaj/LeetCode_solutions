class Solution {
    public String minWindow(String s, String t) {
        int need=0;
        
        int[] requirements=new int[128];
        
        for(int i=0; i<t.length(); i++){
            requirements[t.charAt(i)]++;
            need++;
        }
        
        int si=0;
        int ei=0;
        
        int min_len=(int)(1e9);
        
        int gsi=0;
        int gei=0;
        
        while(ei<s.length()){
            if(requirements[s.charAt(ei)]>0){
                need--;
            }
            
            requirements[s.charAt(ei)]--;
            ei++;
            
            while(need==0){
                if(min_len>(ei-si)){
                    min_len=ei-si;
                    gsi=si;
                    gei=ei;
                }
                
                if(requirements[s.charAt(si)]==0){
                    need++;
                }
                
                requirements[s.charAt(si)]++;
                si++;
            }
        }
        
        return min_len==(int)(1e9) ? "" : s.substring(gsi,gei);
    }
}