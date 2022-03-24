class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        
        int ans=0;
        
        int i=0;
        int j=people.length-1;
        while(i<=j){
            if(i==j){
                ans++;
                break;
            }
            if(people[i] + people[j] <= limit){
                ans++;
                i++;
                j--;
            } else {
                ans++;
                j--;
            }
        }
        return ans;
    }
}