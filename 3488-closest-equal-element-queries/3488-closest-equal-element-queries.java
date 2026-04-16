class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        List<Integer> ans =  new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++) {
           map.putIfAbsent(nums[i], new ArrayList<>());
           map.get(nums[i]).add(i);
        }
        for(int q : queries) {
            List<Integer> list = map.get(nums[q]);
            int minDist = Integer.MAX_VALUE;
            if(list.size()<=1) {
                ans.add(-1);
                continue;
            }
            int size=list.size();
            int pos = Collections.binarySearch(list, q);
            int prev = Math.abs(q-list.get((pos-1+size)%size));
            int next = Math.abs(list.get((pos+1)%size)-q);
            int d1 = Math.min(prev, n-prev);
            int d2 = Math.min(next, n-next);
            minDist = Math.min(minDist, Math.min(d1, d2));
            ans.add(minDist);
        }
        return ans;
    }
}