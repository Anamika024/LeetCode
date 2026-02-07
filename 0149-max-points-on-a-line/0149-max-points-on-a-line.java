class Solution {
    public int maxPoints(int[][] points) {
        int ans=0;
        for(int i=0; i<points.length; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            int same=1; // count duplicates points
            int x1=points[i][0];
            int y1=points[i][1];
            for(int j=i+1; j<points.length; j++) {
                int dx=points[j][0]-x1;
                int dy=points[j][1]-y1;
                if(dx==0 && dy==0) {
                    same++;
                    continue;
                }
                int g = gcd(dx, dy);
                dx/=g;
                dy/=g;

                String key = dy+"/"+dx;
                map.put(key, map.getOrDefault(key, 0)+1);
            }
            int max=0;
            for(int v : map.values()) {
                max= Math.max(max, v);
            }
            ans = Math.max(ans, max+same);
        }
        return ans;


    }
    public int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b, a%b);
    }

}