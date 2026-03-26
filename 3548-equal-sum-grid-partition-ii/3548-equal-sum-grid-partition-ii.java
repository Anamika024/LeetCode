class Solution {
    long total=0;
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                total+=grid[i][j];
            }
        }
        if(check(grid)) return true;
        reverse(grid);
        if(check(grid)) return true;
        reverse(grid);
        //transpose 
        int trans[][] = new int[n][m];
        for(int i=0; i<m; i++) {
             for(int j=0; j<n; j++) {
                trans[j][i]=grid[i][j];
            }
        }
        if(check(trans)) return true;
        reverse(trans);
        return check(trans);

    }
    public boolean check(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        HashSet<Long> set = new HashSet<>();
        long top=0;
        for(int i=0; i<m-1; i++) {
            for(int j=0; j<n; j++) {
                set.add((long)grid[i][j]);
                top+=grid[i][j];
            }

            long bottom = total - top;
            long diff = top - bottom;

            if (diff == 0) return true;

            if (diff == grid[0][0]) return true;
            if (diff == grid[0][n - 1]) return true;
            if (diff == grid[i][0]) return true;

            if (i > 0 && n > 1 && set.contains(diff)) {
                return true;
            }

        }
        return false;
    }
    public void reverse(int[][] grid) {
        int t=0, b=grid.length-1;
        while(t<b) {
            int temp[]=grid[t];
            grid[t]=grid[b];
            grid[b]=temp;
            t++;
            b--;
        }
    }

}