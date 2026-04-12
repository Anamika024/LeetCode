class Solution {
    Integer dp[][][][][]= new Integer[301][7][7][7][7];
    public int minimumDistance(String word) {
        return solve(word, 0, -1, -1, -1, -1);
    }
    public int solve(String word, int i, int x1, int y1, int x2, int y2) {
        if(i>=word.length()) {
            return 0;
        }
        if(dp[i][x1+1][y1+1][x2+1][y2+1]!=null) {
            return dp[i][x1+1][y1+1][x2+1][y2+1];
        }
        int r = (word.charAt(i)-'A')/6;
        int c = (word.charAt(i)-'A')%6;

        //non fingers used
        if(x1==-1 && y1==-1 && x2==-1 && y2==-1) {
            return dp[i][x1+1][y1+1][x2+1][y2+1]=solve(word, i+1, r, c, x2, y2);
        }
        //f2 not used
        if(x2==-1 && y2==-1) {
            int moveF2=solve(word, i+1, x1, y1, r, c);
            int moveF1=Math.abs(x1-r)+Math.abs(y1-c)+solve(word, i+1, r, c, x2, y2);
            return dp[i][x1+1][y1+1][x2+1][y2+1]=Math.min(moveF1, moveF2);
        }
        //both used
        int moveF2=Math.abs(x2-r)+Math.abs(y2-c)+solve(word, i+1, x1, y1, r, c);
        int moveF1=Math.abs(x1-r)+Math.abs(y1-c)+solve(word, i+1, r, c, x2, y2);

        return dp[i][x1+1][y1+1][x2+1][y2+1]=Math.min(moveF1, moveF2);

    }
}