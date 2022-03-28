class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        
        int left=0;
        int right=n-1;
        int max_area=0;
        
        while(left<right){
            int h=Math.min(height[left],height[right]);
            int width=right-left;
            
            int area=h*width;
            
            max_area=Math.max(area,max_area);
            
            if(height[left]<height[right]){
                left++;
            } else {
                right--;
            }
        }
        
        return max_area;
    }
}