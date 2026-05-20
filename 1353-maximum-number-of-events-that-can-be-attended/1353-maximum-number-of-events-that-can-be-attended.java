class Solution {
    public int maxEvents(int[][] events) {
        int n = events.length;

        Arrays.sort(events, (a, b)-> a[0]-b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int day=events[0][0];
        int i=0;
        int count=0;

        while(i<n || !pq.isEmpty()) {
            while(i<n  && events[i][0]==day) { // add all available events at day "day"
                pq.offer(events[i][1]);
                i++;
            }

            if(!pq.isEmpty()) { // attend event ending soonest
                pq.poll();
                count++;
            }
            day++;
            
            // remove old events whose day is finished
            while(!pq.isEmpty() && pq.peek()<day) {
                pq.poll();
            }
            
        }
        return count;   
    }
}