class Solution {
    Long[][] dp;
    int[] nums;
    int n;
    public long maxSumTrionic(int[] nums) {
        this.nums = nums;
        n=nums.length;
        dp=new Long[n+1][4];
        return solve(0, 0);
        
    }
    public long solve(int i, int phase) {

        if(i==n) {
            return phase==3 ? 0 : Long.MIN_VALUE/2;
        }
        if (dp[i][phase] != null) return dp[i][phase];

        long ans = Long.MIN_VALUE / 2;

        if(phase==0) {
            ans=solve(i+1, 0);
        }
        if(phase==3) {
            ans=nums[i]; //finish
        }

        if(i+1<nums.length) {
            int curr = nums[i];
            int next = nums[i+1];

            if(phase==0 && next>curr) {
                ans = Math.max(ans, curr+solve(i+1, 1));
            }else if(phase==1) {//inc
                if(next>curr) {
                    ans=Math.max(ans, curr+solve(i+1, 1));
                }else if(next<curr){
                    ans=Math.max(ans, curr+solve(i+1, 2));

                }

            }else if(phase==2) {//dec
                if(next<curr) {
                    ans=Math.max(ans, curr+solve(i+1, 2));
                }else if(next>curr){
                    ans=Math.max(ans, curr+solve(i+1, 3));

                }

            }else if(phase==3 && next>curr) {//inc
                ans=Math.max(ans, curr+solve(i+1, 3));

            }
        }
        return dp[i][phase]=ans;

    }
}