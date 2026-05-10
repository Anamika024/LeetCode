class Solution {
    int n;
    Integer dp[];
    public int maximumJumps(int[] nums, int target) {
        n=nums.length;
        dp=new Integer[n];
        int res = solve(nums, target, 0);
        return res<0 ? -1 : res;
        
    }
    public int solve(int[] nums, int target, int i) {
        if(i==n-1) {
            return 0;
        }
        if(dp[i]!=null) {
            return dp[i];
        }
        int max=Integer.MIN_VALUE;
        for(int j=i+1; j<n; j++) {
            if(Math.abs(nums[i]-nums[j])<=target) {
                int temp = 1+solve(nums, target, j);
                max=Math.max(max, temp);
            }
        }
        return dp[i]=max;

    }
}