class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;

        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0; i<n; i++){
            int ele=nums[i];

            if(map.containsKey(ele)){
                int fre=map.get(ele);

                map.put(ele,fre+1);
            } else {
                map.put(ele,1);
            }
        }

        for(int i=0; i<n; i++){
            int ele=nums[i];

            int fre=map.get(ele);
            if(fre>n/2) return ele;
        }

        return -1;
    }
}