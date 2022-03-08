class Solution {
    public int subarraysDivByK(int[] a, int k) {
        int csum=0;
        int count=0;
        
        HashMap<Integer,Integer> map=new HashMap<>(); // rem vs indexes;
        map.put(0,1);
        
        for(int i=0; i<a.length; i++){
            csum+=a[i];
            
            int rem=csum%k;
            
            if(rem<0){
                rem=rem+k;
            }
            
            if(map.containsKey(rem)){
                count+=map.get(rem);
                map.put(rem,map.get(rem)+1);
            } else {
                map.put(rem,1);
            }
        }
        
        return count;
    }
}