class Solution {
public:
    int BS(vector<int>& dp, int h){
    int l=0;
    int r=dp.size()-1;

    while(l<=r){
        int mid=(l+r)/2;

        if(dp[mid]<h){
            l=mid+1;
        } else {
            r=mid-1;
        }
    }

    return l;
}

int maxEnvelopes(vector<vector<int>>& envelopes) {

    sort(envelopes.begin(),envelopes.end(),[](vector<int>& a,vector<int>& b){
        if(a[0]==b[0]) return a[1] > b[1];

        return a[0] < b[0];
    }); 

    // Arrays.sort(envelopes,(int[] a, int[] b)->{
    //     if(a[0]==b[0]) return b[1] - a[1];

    //     return a[0] - b[0];
    // }); 

    int n=envelopes.size();  

    vector<int> dp;

    for(int i=0; i<n; i++){
        int h=envelopes[i][1];

        int idx=BS(dp,h);
        if(idx==dp.size()){
            dp.push_back(h);
        } else {
            dp[idx]=h;
        }
    }

    return dp.size();
}

};