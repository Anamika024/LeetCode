class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int min=Integer.MAX_VALUE;
        for(int j=0; j<n; j++) {
            int rev = reverse(nums[j]);
            if(map.containsKey(nums[j])) {
                int i= map.get(nums[j]);
                min = Math.min(min, j-i);
            }
            map.put(rev, j);
        }

        return min==Integer.MAX_VALUE ? -1 : min;
    }
    public int reverse(int num) {
        int res=0;
        while(num>0) {
            int rem=num%10;
            res=res*10+rem;
            num/=10;
        }
        return res;

    }
}