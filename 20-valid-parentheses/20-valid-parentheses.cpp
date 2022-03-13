class Solution {
public:
    bool isValid(string st) {
        stack<char> s;
        for(int i=0;i<st.size(); i++){
            if(st[i]=='(' || st[i]=='[' || st[i]=='{'){
                s.push(st[i]);
            } else if(st[i]==')'){
                if(s.size()==0) return false;
                if(s.size()>0 && s.top()!='('){
                    return false;
                }
                s.pop();
                //if(s.size()!=0) return false;
            } else if(st[i]=='}'){
                 if(s.size()==0) return false;
                if(s.size()>0 && s.top()!='{'){
                    return false;
                }
                s.pop();
            } else if(st[i]==']'){
                 if(s.size()==0) return false;
                if(s.size()>0 && s.top()!='['){
                    return false;
                }
                s.pop();
            }// else {
            //     s.pop();
            // }
            cout<<"saq"<<" ";
            
        //cout<<s.top()<<" ";
            }
            
    
        if(s.size()!=0) return false;
        return true;
    }
};