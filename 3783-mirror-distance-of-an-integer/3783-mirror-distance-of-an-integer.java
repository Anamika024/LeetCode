class Solution {
    public int mirrorDistance(int n) {
        int rev = reverse(n);
        return Math.abs(n-rev);
    }
    public int reverse(int n) {
        int res=0;
        while(n>0) {
            res=res*10+n%10;
            n/=10;
        }
        return res;
    }

}