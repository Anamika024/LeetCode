class Solution {
    public int maxRotateFunction(int[] nums) {
        int n=nums.length;
        //f(1)=f(0)+sum-n*nums[n-1]
        //f(k)=f(k-1)+sum-n*nums[n-k];
        
        long f=0, sum=0;
        for(int i=0; i<n; i++) {
            sum+=nums[i];
            f+=nums[i]*i;
        }
        long max=f;
        for(int k=1; k<n; k++) {
            f=f+sum-(long)n*nums[n-k];
            max=Math.max(max, f);
        }
        return max==Long.MIN_VALUE ? 0 : (int)max;
        
    }
}