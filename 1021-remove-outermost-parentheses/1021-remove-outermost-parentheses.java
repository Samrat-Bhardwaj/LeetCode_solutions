class Solution {
    public String removeOuterParentheses(String s) {
        int a=0;
        
        String ans="";
        
        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);
            
            if(ch=='('){
                if(a!=0){
                    ans+=ch;
                }
                
                a++;
            } else {
                if(a!=1){
                    ans+=ch;
                }
                
                a--;
            }
        }
        
        return ans;
    }
}