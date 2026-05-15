class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        if(nums[0]<nums[n-1]) {
            return nums[0];
        }
        int l=0, r=n-1, min=5001;
        while(l<=r) {
            if(nums[l]>=nums[r]) {
                min=Math.min(min, nums[r]);
            }else {
                min=Math.min(min, nums[l]);
            }
            l++;
            r--;
        }
        return min;

    }
}