class Solution {
    int m,n;
    long max=Long.MIN_VALUE;
    int mod=1000000007;
    long minDp[][];
    long maxDp[][];
    public int maxProductPath(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        minDp=new long[m][n];
        maxDp=new long[m][n];
        for(int i=0; i<m; i++) {
            Arrays.fill(minDp[i], Long.MAX_VALUE);
            Arrays.fill(maxDp[i], Long.MIN_VALUE);
        }
        solve(grid, 0, 0, grid[0][0]);
        return max<0 ? -1 : (int) (max%mod);

    }
    public void solve(int[][] grid, int r, int c, long prod) {
        if (prod <= maxDp[r][c] && prod >= minDp[r][c]) return;
        maxDp[r][c] = Math.max(maxDp[r][c], prod);
        minDp[r][c] = Math.min(minDp[r][c], prod);
        if(r==m-1 && c==n-1) {
            if(prod>=0) max=Math.max(max, prod);
            return;
        }

        if(r+1<m) {
            solve(grid, r+1, c, prod*grid[r+1][c]);
        }
        if(c+1<n) {
            solve(grid, r, c+1, prod*grid[r][c+1]);
        }
    }
}