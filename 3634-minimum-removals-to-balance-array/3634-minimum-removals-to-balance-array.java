class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int i=0, max=1;
        for(int j=1; j<n; j++) {
            while(nums[j]>(long)k*nums[i]) {
                i++;
            }
            max=Math.max(max, j-i+1);

        }
        
        return n-max;
    }
}