class Solution {
    public int smallestBalancedIndex(int[] nums) {
        int n = nums.length;

        long[] sum = new long[n];
        sum[0] = 0;

        for(int i=1; i<n; i++){
            sum[i]=sum[i-1]+nums[i-1];
        }

        long prod = 1;

        for(int i=n-1; i>=0; i--) {
            long s = (i==0) ? 0 : sum[i];
            long p = (i==n-1) ? 1 : prod;
            if(s == p) return i;
            if(i > 0) {
                if(prod>1e14/nums[i]) { //maxproductValue = 10^9*10^5=10^14=1e14
                    // prod = (long)1e14 +1;// assigining greater value from maxProductValue
                    break;
                } else {
                    prod *= nums[i];
                }
            }
        }
        return -1;

    }
}