class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long rowSum1[] = new long[m];
        for(int i=0; i<m; i++) {
            long sum=0;
            for(int j=0; j<n; j++) {
                sum+=grid[i][j];
            }
            rowSum1[i]= i==0 ? sum : rowSum1[i-1]+sum;
        }
        long rowSum2[] = new long[m];
        for(int i=m-1; i>=0; i--) {
            long sum=0;
            for(int j=0; j<n; j++) {
                sum+=grid[i][j];
            }
            rowSum2[i]= i==m-1 ? sum : rowSum2[i+1]+sum;
        }

        for(int i=0; i<m-1; i++) {
            if(rowSum1[i]==rowSum2[i+1]) {
                return true;
            }
        }
        long colSum1[] = new long[n];
        for(int j=0; j<n; j++) {
            long sum=0;
            for(int i=0; i<m; i++) {
                sum+=grid[i][j];
            }
            colSum1[j]= j==0 ? sum : colSum1[j-1]+sum;
        }
        long colSum2[] = new long[n];
        for(int j=n-1; j>=0; j--) {
            long sum=0;
            for(int i=0; i<m; i++) {
                sum+=grid[i][j];
            }
            colSum2[j]= j==n-1 ? sum : colSum2[j+1]+sum;
        }
        for(int j=0; j<n-1; j++) {
            if(colSum1[j]==colSum2[j+1]) return true;
        }
        return false;
        

        
    }
}