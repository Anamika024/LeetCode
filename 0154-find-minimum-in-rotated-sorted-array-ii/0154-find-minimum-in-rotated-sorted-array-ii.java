class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if(n==1 || nums[0]<nums[n-1]) return nums[0];
        int l=0, r=n-1;

        while(l<r) {
            while(l<r && nums[l]==nums[l+1]) l++;
            while(l<r && nums[r]==nums[r-1]) r--;

            int mid=l+(r-l)/2;
            if(nums[mid]>nums[r]) {
                l=mid+1;
            }else {
                r=mid;
            }
        }
        return nums[l];
    }
}