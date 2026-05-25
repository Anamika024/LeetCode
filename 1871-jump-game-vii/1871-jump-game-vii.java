class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if(s.charAt(n-1)=='1') return false;

        Queue<Integer> q = new LinkedList<>();

        q.offer(0);
        int startIdx=0;
        while(!q.isEmpty()) {
            int i = q.poll();
            int start = Math.max(i+minJump, startIdx+1);
            int end = Math.min(i+maxJump, n-1);

            for(int j=start; j<=end; j++) {
                if(s.charAt(j)=='0') {
                    if(j==n-1) return true;
                    q.offer(j);
                }
            }
            startIdx=end;
        }
        return false;
    }
}