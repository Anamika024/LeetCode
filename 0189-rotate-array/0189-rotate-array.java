class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k=k%n;
        revese(nums, 0, n-1); // 7,6,5,4,3,2,1
        revese(nums, 0, k-1); // revese first half(k=3)-> 5,6,7,4,3,2,1
        revese(nums, k, n-1); // reverse second half-> 5,6,7,1,2,3,4 
        
        //tc: O(N), sc:O(1)
    }
    public void revese(int[] nums, int l, int r) {
        while(l<r) {
            int temp = nums[l];
            nums[l]=nums[r];
            nums[r]=temp;
            l++;
            r--;
        }
    }
}