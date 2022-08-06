class Solution {
public:
    int countSquares(vector<vector<int>>& matrix) {
        int ans=0;
        
        for(int i=0; i<matrix.size(); i++){
            for(int j=0; j<matrix[i].size(); j++){
                if(i==0 || j==0){
                    ans+=matrix[i][j];
                } else {
                    int m=min(matrix[i-1][j],min(matrix[i][j-1],matrix[i-1][j-1]));
                    if(matrix[i][j]==1){
                        ans+=m+1;
                        matrix[i][j]=m+1;
                    }
                }
            }
        }
        
        return ans;
    }
};