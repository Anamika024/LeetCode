class Solution {
    public int maxEvents(int[][] events) {
        int n = events.length;

        Arrays.sort(events, Comparator.comparing(a->a[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int day=events[0][0];
        int i=0;
        int count=0;

        while(i<n || !pq.isEmpty()) {
            while(i<n  && events[i][0]==day) {
                pq.offer(events[i][1]);
                i++;
            }

            if(!pq.isEmpty()) {
                pq.poll();
                count++;
            }
            day++;

            while(!pq.isEmpty() && pq.peek()<day) {
                pq.poll();
            }
            
        }
        return count;   
    }
}