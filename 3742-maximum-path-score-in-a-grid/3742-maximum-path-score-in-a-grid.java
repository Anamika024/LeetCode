class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int dp[][][] = new int[m][n][k+1];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        for(int i=m-1; i>=0; i--) {
            for(int j=n-1; j>=0; j--) {
                for(int c=k; c>=0; c--) {
                    int cost = c+(grid[i][j]>0 ? 1 : 0);
                    if(cost>k) continue;
                    if(i==m-1 && j==n-1) {
                        dp[i][j][c]=grid[i][j];
                        continue;
                    }
                    int right=-1, down=-1;
                    if(j+1<n) {
                        right=dp[i][j+1][cost];
                    }
                    if(i+1<m) {
                        down=dp[i+1][j][cost];
                    }
                    int best =Math.max(right, down);
                    if(best!=-1) {
                        dp[i][j][c]=best+grid[i][j];

                    }
                }
            }
        }
        return dp[0][0][0];
        
    }
}