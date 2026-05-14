class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        int max=n-1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            if(num>max) return false;
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        if(map.getOrDefault(max, 0)!=2) {
            return false;
        }
        for(int i=1; i<max; i++) {
            if(map.getOrDefault(i, 0)!=1) {
                return false;
            }
        }
        return true;
    }
}