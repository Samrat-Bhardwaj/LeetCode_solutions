class Solution {
    public List<List<Integer>> twoSum(int[] nums, int si, int ei, int tar){
        List<List<Integer>> ans=new ArrayList<>();

        while(si<ei){
            int csum=nums[si]+nums[ei];

            if(csum==tar){
                List<Integer> smallAns=new ArrayList<>();
                smallAns.add(nums[si]);                
                smallAns.add(nums[ei]);

                ans.add(smallAns);
                
                si++;
                ei--;

                while(si<ei && nums[si-1]==nums[si]) si++;
                while(si<ei && nums[ei+1]==nums[ei]) ei--;
            } else if(csum<tar){
                si++;
            } else {
                ei--;
            }
        }

        return ans;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        int tar=0;

        List<List<Integer>> ans=new ArrayList<>();

        for(int fixi=0; fixi<nums.length; ){
            List<List<Integer>> smallAns=twoSum(nums,fixi+1,nums.length-1,tar-nums[fixi]);

            makeAns(ans,smallAns,nums[fixi]);

            fixi++;

            // remove duplicates
            while(fixi<nums.length && nums[fixi]==nums[fixi-1]) fixi++;
        }
        
        return ans;
    }

    public void makeAns(List<List<Integer>> ans,List<List<Integer>> smallAns, int ele){
        for(List<Integer> s:smallAns){
            s.add(ele);
            ans.add(s);
        }
    }
}