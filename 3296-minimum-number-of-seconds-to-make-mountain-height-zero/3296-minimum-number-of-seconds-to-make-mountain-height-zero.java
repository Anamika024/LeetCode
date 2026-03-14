class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        int n = workerTimes.length;
        Arrays.sort(workerTimes);
        long l=1; // minTime
        long r= 1L*workerTimes[n-1]*mountainHeight*(mountainHeight+1)/2; // maxTime 
        if(n==1) return r;//OPTIONAL

        //minimise the max (binary search on ans);
        long result=0;
        while(l<=r) {
            long mid = l+(r-l)/2;
            if(check(mid, workerTimes, mountainHeight)) {
                result=mid;
                r=mid-1;
            }else {
                l=mid+1;
            }
        }
        return result;   
    }
    public boolean check(long mid, int[] wt, long hMax) {
        long h =0;
        for(int t : wt) {
            h +=(long) (Math.sqrt(2.0*mid/t+0.25)-0.5);
            if(h>=hMax) {
                return true;
            }
        }
        return h>=hMax;
    }



}