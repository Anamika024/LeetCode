class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;
        int events[][] = new int[2*n][2];
        int i=0;

        for(int trip[] : trips) {
            int delta = trip[0];
            int from = trip[1];
            int to = trip[2];
            events[i][0]=from;
            events[i++][1]=delta;
            events[i][0]=to;
            events[i++][1]=-delta;

        }
        Arrays.sort(events, (a, b)-> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]); // (3, 2, 7), (3, 7, 9) handle when start time and end tome of event is equal, in this case neg delta process first

        int count=0;
        for(int event[] : events) {
            count+=event[1];
            if(count>capacity) {
                return false;
            }
        }
        return true;
        
    }
}