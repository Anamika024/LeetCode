class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        // int maxG=g[g.length-1];
        // int maxS=s[s.length-1];

        // int minLen = Math.min(g.length, s.length);

        int i=0, j=0, ans=0;
        while(i<g.length && j<s.length) {
            if(s[j]>=g[i]) {
                i++;
                j++;
                ans++;
            }else if(s[j]<g[i]) {
                j++;
            }
        }
        return ans;

        
    }
}