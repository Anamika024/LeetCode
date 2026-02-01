class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length, min=Integer.MAX_VALUE;
        for(int k=2; k<n; k++) {
            for(int i=0; i<n-k; i++){
                min = Math.min(min, nums[0]+nums[i+1]+nums[i+k]);
            }
        }
        return min;

        
    }
}