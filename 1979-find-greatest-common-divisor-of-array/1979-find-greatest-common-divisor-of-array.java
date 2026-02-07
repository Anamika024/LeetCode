class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        return gcd(nums[0], nums[nums.length-1]);
        
    }
    public int gcd(int a, int b) {
        while(b!=0) {
            int r = a%b;
            a=b;
            b=r;
        }
        return a;
    }
}