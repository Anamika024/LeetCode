class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        if(n<3) return -1;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            int key = nums[i];
            List<Integer> list = map.getOrDefault(key, new ArrayList<>());
            list.add(i);
            map.put(key, list);
            int size = map.get(key).size();
            int dist=0;
            if(size>=3) {
                for(int j=0; j<size-2; j++) {
                    int a = map.get(key).get(j);
                    int b = map.get(key).get(j+1);
                    int c = map.get(key).get(j+2);
                    dist = Math.abs(a-b)+Math.abs(b-c)+Math.abs(c-a);
                    min=Math.min(min, dist);
                }
            }
        }
        return min==Integer.MAX_VALUE ? -1 : min;
    }
}