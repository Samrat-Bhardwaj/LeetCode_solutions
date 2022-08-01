class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set=new HashSet<>();
        
        for(int i=0; i<nums1.length; i++){
            set.add(nums1[i]);
        }
        
        ArrayList<Integer> al=new ArrayList<>();
        
        for(int i=0; i<nums2.length; i++){
            int ele=nums2[i];
            
            if(set.contains(ele)){
                al.add(ele);
                set.remove(ele);
            }
        }
        
        int[] ans=new int[al.size()];
        
        for(int i=0; i<ans.length; i++){
            ans[i]=al.get(i);
        }
        
        return ans;
    }
}