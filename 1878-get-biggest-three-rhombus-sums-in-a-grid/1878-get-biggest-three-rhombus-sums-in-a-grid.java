class Solution {
    public int[] getBiggestThree(int[][] grid) {
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        int m = grid.length;
        int n = grid[0].length;

        for(int r=0; r<m; r++) {
            for(int c=0; c<n; c++) {
                set.add(grid[r][c]); //for side=0
                for(int s=1; r-s>=0 && r+s<m && c-s>=0 && c+s<n; s++) {
                    int sum=0;
                    for(int k=0; k<s; k++) {
                        sum+=grid[r-s+k][c+k];//top to right diagonal
                        sum+=grid[r+k][c+s-k];//right to bottom diagonal
                        sum+=grid[r+s-k][c-k];//bottom to left diagonal
                        sum+=grid[r-k][c-s+k];//left to top diagonal
                    }
                    set.add(sum);
                }
            }
        }
        int size = Math.min(3, set.size());
        int ans[] = new int[size];
        int idx=0;
        for(int val : set) {
            ans[idx++]=val;
            if(idx==size) break;
        }
        return ans;

    }
}