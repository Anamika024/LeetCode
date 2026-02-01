class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length, min=Integer.MAX_VALUE;
        if(n==3) {
            return nums[0]+nums[1]+nums[2];
        }
        for(int k=2; k<n-1; k++) {
            for(int i=0; i<n-k; i++){
                min = Math.min(min, nums[0]+nums[i+1]+nums[i+k]);
            }
        }
        return min;

        
    }
}