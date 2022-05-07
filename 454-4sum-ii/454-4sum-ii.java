class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer,Integer> map=new HashMap<>();
        // generating A's
        for(int a:nums1){
            for(int b:nums2){
                int A=a+b;
                map.put(A,map.getOrDefault(A,0)+1);
            }
        }
        
        int count=0;
        
        for(int c:nums3){
            for(int d:nums4){
                int B=c+d;
                
                int toFind=0-B;
                
                if(map.containsKey(toFind))
                    count+=map.get(toFind);
            }
        }
        
        return count;
    }
}