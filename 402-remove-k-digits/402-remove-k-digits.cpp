class Solution {
public:
    string removeKdigits(string num, int k) {
        // 14342          k=3
        // 1$3$2
        // 132 -> 1$2
        // 32
        //12
        
        int n=num.size();
        vector<char> st;
        
        for(int i=0; i<n; i++){
            char ch=num[i];
            
            while(st.size()!=0 && k>0 && st.back()>ch){
                st.pop_back();
                k--;
            }
            
            if(st.size()==0 && ch=='0'){
                continue;
            }
            
            st.push_back(ch);
        }
        
        while(st.size()!=0 && k--){
            st.pop_back();
        }
        
        string ans="";
        for(int i=0; i<st.size(); i++){
            ans+=st[i];
        }
        
        return ans.size()==0 ? "0" : ans;
    }
};