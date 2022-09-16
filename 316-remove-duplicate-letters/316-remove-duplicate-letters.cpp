class Solution {
public:
    string removeDuplicateLetters(string s) {
        vector<int> fre(26,0);
        vector<bool> vis(26,false);
        
        for(char c:s){
            fre[c-'a']++;
        }
        
        vector<char> st;
        
        for(char ch:s){
            fre[ch-'a']--;
            
            if(vis[ch-'a']){ // if it is inside my stack
                continue;
            }
            
            while(st.size()!=0 && st.back()>ch && fre[st.back()-'a']>0){
                vis[st.back()-'a']=false;
                st.pop_back();
            }
            
            st.push_back(ch);
            vis[ch-'a']=true;
        }
        
        string ans="";
        for(int i=0; i<st.size(); i++){
            ans+=st[i];
        }
        
        return ans;
    }
};