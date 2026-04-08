class Solution {
    int mod = 1000000007;
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        for(int q[] : queries) {
            int l=q[0], r=q[1], k=q[2], v=q[3];
            for(int i=l; i<=r; i+=k) {
                nums[i]=(int)((nums[i]*1L*v)%mod);
            }
        }
        int xor=0;
        for(int num : nums) {
            xor^=num;
        }
        return xor;
        
    }
}