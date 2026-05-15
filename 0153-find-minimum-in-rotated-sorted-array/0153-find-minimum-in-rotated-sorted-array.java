class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        if(nums[0]<nums[n-1]) {
            return nums[0];
        }
        int l=0, r=n-1;
        while(l<r) {
            int mid = l+(r-l)/2;
            if(nums[mid]>nums[r]) {
                l=mid+1; // min is in right half
            }else {
                r=mid; // min is in left half
            }
        }
        return nums[l];

    }
}