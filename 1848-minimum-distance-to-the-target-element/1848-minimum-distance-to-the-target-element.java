class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int n = nums.length;
        int leftMin=n, rightMin=n;

        for(int i=start; i>=0; i--) {
            if(nums[i]==target) {
                leftMin=Math.abs(i-start);
                break;
            }
        }
        for(int i=start; i<n; i++) {
            if(nums[i]==target) {
                rightMin=Math.abs(i-start);
                break;
            }
        }
        return Math.min(leftMin, rightMin);

    
    }
}