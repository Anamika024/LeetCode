class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        long total=0;
        for(int r[] : grid) {
            for(int v : r) {
                total+=v;
            }
        }

        long curr=0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                curr+=grid[i][j];
            }
            if(curr==total-curr) return true;
        }
        curr=0;
        for(int j=0; j<m; j++) {
            for(int i=0; i<n; i++) {
                curr+=grid[i][j];
            }
            if(curr==total-curr) return true;
        }
        return false;


        
    }
}