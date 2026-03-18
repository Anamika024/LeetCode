class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int count=0;

        int rowSum[][] = new int[m][n];
        int colSum[][] = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                rowSum[i][j] = j==0 ? grid[i][j] : rowSum[i][j-1]+grid[i][j];
                colSum[i][j] = i==0 ? grid[i][j] : colSum[i-1][j]+grid[i][j];
            }
        }
        for(int j=0; j<n; j++) {
            if(rowSum[0][j]<=k) count++;
        }
        for(int i=1; i<m; i++) {
            if(colSum[i][0]<=k) count++;
        }
        for(int i=1; i<m; i++) {
            for(int j=0; j<n; j++) {
                rowSum[i][j]+=rowSum[i-1][j];
                if((i>0 && j>0) && rowSum[i][j]<=k) count++;
            }
        }
        return count;



    }
}