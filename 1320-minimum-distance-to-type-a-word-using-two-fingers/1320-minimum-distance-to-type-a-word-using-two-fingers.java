class Solution {
    Integer dp[][][] = new Integer[301][27][27];
    public int minimumDistance(String word) {
        return solve(word, 0, 26, 26);
    }
    public int solve(String word, int i, int f1, int f2) {
        if(i>=word.length()) {
            return 0;
        }
        if(dp[i][f1][f2]!=null) {
            return dp[i][f1][f2];
        }
        int curr = word.charAt(i)-'A';

        //non fingers used
        if(f1==26 && f2==26) {
            return dp[i][f1][f2]=solve(word, i+1, curr, f2);
        }
        //f2 not used
        if(f2==26) {
            int moveF2=solve(word, i+1, f1, curr);
            int moveF1=getDist(f1, curr)+solve(word, i+1, curr, f2);
            return dp[i][f1][f2]=Math.min(moveF1, moveF2);
        }
        //both used
        int moveF2=getDist(f2, curr)+solve(word, i+1, f1, curr);
        int moveF1=getDist(f1, curr)+solve(word, i+1, curr, f2);

        return dp[i][f1][f2]=Math.min(moveF1, moveF2);

    }
    public int getDist(int pos1, int pos2) {
        int r1 = pos1/6, c1=pos1%6;
        int r2 = pos2/6, c2=pos2%6;
        return Math.abs(r1-r2)+Math.abs(c1-c2);
    }
}