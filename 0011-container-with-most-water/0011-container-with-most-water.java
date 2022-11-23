class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        
        int ans = 0;
        int i=0;
        int j=n-1;
        
        while(i<j){
            int h = Math.min(height[i],height[j]);
            int w = j - i;
            
            int currArea = h*w;
            if(currArea > ans){
                ans = currArea; // getting a new maximum
            }
            
            if(height[i] <= height[j]){
                i++;
            } else {
                j--;
            }
        }
        
        return ans;
    }
}