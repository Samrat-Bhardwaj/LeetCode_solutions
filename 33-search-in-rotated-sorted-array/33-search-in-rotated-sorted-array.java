class Solution {
    public int search(int[] arr, int target) {
        int si=0;
        int ei=arr.length-1;
        
        while(si<=ei){
            int mid=(si+ei)/2;
            
            if(arr[mid]==target) return mid;
            
            if(arr[si]<=arr[mid]){ // region from si to mid is sorted
                if(arr[si]<=target && arr[mid]>target){
                    ei=mid-1;
                } else {
                    si=mid+1;
                }
            } else {
                if(arr[mid]<target && arr[ei]>=target){
                    si=mid+1;
                } else {
                    ei=mid-1;
                }
            }
        }
        
        return -1;
    }
}