class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length, n=grid[0].length;
        if(m==0 || n==0) return 0;
        int count=0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j]=='1') {
                    dfs(i, j);
                    count++;
                }
            }
        }
        return count;
        
    }
    public void dfs(char[][] grid, int i, int j) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length) return;

        grid[i][j]='0'; //marked visited
        dfs(grid, i+1, j);
        dfs(grid, i+1, j);dfs(grid, i+1, j);
    }
}