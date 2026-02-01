class Solution {
    public int minimumCost(int[] nums) {
        // int n = nums.length, min=Integer.MAX_VALUE;
        // for(int k=2; k<n; k++) {
        //     for(int i=0; i<n-k; i++){
        //         min = Math.min(min, nums[0]+nums[i+1]+nums[i+k]);
        //     }
        // }
        // return min;

        // int n = nums.length;
        // Arrays.sort(nums, 1, n);
        // return nums[0]+nums[1]+nums[2];

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for(int i=1; i<nums.length; i++) {
            if(nums[i]<min1) {
                min2=min1;
                min1=nums[i];
            }else if(nums[i]<min2) {
                min2=nums[i];
            }
        }
        return nums[0]+min1+min2;


        
    }
}