class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int n = moves.length();
        int l=0, r=0;
        for(char c : moves.toCharArray()) {
            if(c=='L') {
                l++;
            }else if(c=='R') {
                r++;
            }
        }
        int black=n-(l+r);
        return black+Math.abs(l-r);

        
    }
}