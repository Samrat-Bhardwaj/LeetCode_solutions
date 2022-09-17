class Solution {
public:
    int minInsertions(string s) {
        int a=0;
        int ans=0;
        for(int i=0; i<s.size(); i++){
            if(s[i]=='('){
                a++;
            } else {
                if(i+1<s.size() && s[i+1]==')') i++;
                else ans++;
                
                a--;
            }
            
            if(a<0){
                a=0;
                ans++;
            }
        }
        
        return ans+2*a;
    }
};