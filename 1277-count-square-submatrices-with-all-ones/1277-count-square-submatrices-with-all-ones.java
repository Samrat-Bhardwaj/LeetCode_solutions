class Solution {
    public int countSquares(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int ans=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j]==1){
                    if(i==0 || j==0){
                        ans+=1;
                    } else {
                        int size=Math.min(matrix[i-1][j],Math.min(matrix[i][j-1],matrix[i-1][j-1]));
                        ans+=size+1;
                        matrix[i][j]=size+1;
                    }
                }
            }
        }
        
        return ans;
    }
}