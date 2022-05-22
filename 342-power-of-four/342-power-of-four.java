class Solution {
    public boolean isPowerOfFour(int n) {
        boolean power2=n>0 && (n&(n-1))==0;
        
        return power2 && (n-1)%3==0;
    }
}