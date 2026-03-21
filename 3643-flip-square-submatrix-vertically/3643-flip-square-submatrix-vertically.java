class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int m = grid.length;
        int n = grid[0].length;
        for(int j=y; j<y+k; j++) {
            int t=x, b=x+k-1;
            while(t<=b) {
                int temp=grid[t][j];
                grid[t][j]=grid[b][j];
                grid[b][j]=temp;
                t++;
                b--;
            }
        }
        return grid;
        
    }
}