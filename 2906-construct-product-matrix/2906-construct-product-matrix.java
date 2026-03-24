class Solution {
    int mod=12345;
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int prefix[][] = new int[n][m];
        int suffix[][] = new int[n][m];
        int p=1, s=1;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                prefix[i][j]=p;
                p=(p*(grid[i][j]%mod))%mod;
            }
        }
        for(int i=n-1; i>=0; i--) {
            for(int j=m-1; j>=0; j--) {
                suffix[i][j]=s;
                s=(s*(grid[i][j]%mod))%mod;
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                System.out.print(prefix[i][j] + " ");
                grid[i][j]=(prefix[i][j]*suffix[i][j])%mod;
            }
            System.out.println();
        }
        return grid;
    }
}