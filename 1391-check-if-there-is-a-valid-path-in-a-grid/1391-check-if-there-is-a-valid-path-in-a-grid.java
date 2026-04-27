class Solution {
    int m, n;
    HashMap<Integer, int[][]> dirs = new HashMap<>();
    public Solution() {
        dirs.put(1, new int[][]{{0, -1}, {0, 1}});
        dirs.put(2, new int[][]{{-1, 0}, {1, 0}});
        dirs.put(3, new int[][]{{0, -1}, {1, 0}});
        dirs.put(4, new int[][]{{0, 1}, {1, 0}});
        dirs.put(5, new int[][]{{0, -1}, {-1, 0}});
        dirs.put(6, new int[][]{{0, 1}, {-1, 0}});
    }
    public boolean hasValidPath(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        boolean[][] visited = new boolean[m][n];
        return dfs(grid, 0, 0, visited);

    }
    public boolean dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if(i==m-1 && j==n-1) return true;
        visited[i][j]=true;

        for(int[] dir : dirs.get(grid[i][j])) {
            int new_i = i+dir[0];
            int new_j = j+dir[1];
            if(new_i<0 || new_i>=m || new_j<0 || new_j>=n || visited[new_i][new_j]) {
                continue;
            }
            for(int[] backDir : dirs.get(grid[new_i][new_j])) {
                if(new_i+backDir[0]==i && new_j+backDir[1]==j) {
                    if(dfs(grid, new_i, new_j, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}