class Solution {
    // O(n+m);
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        
        int i=0;
        int j=m-1;
        
        while(i<n && j<m && i>=0 && j>=0){
            int ele=matrix[i][j];
            
            if(ele>target){
                j--;
            } else if(ele<target){
                i++;
            } else {
                return true;
            }
        }
        
        return false;
    }
}