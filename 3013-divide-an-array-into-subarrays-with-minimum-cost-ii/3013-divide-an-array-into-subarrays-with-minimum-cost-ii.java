class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        int wind = dist+1;
        Long min=Long.MAX_VALUE;
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int need = k-1;

        for(int i=1; i+wind<=n; i++) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int j=0; j<wind; j++) {
                pq.add(nums[i+j]);
            }
            long sum=0;
            int count=need;
            while(count-->0) {
                // System.out.print(pq.peek() + " ");
                sum+=pq.poll();
            }
            min=Math.min(min, sum);
        }
        return nums[0]+min;

    }
}