class Solution {
    public int[] getBiggestThree(int[][] grid) {
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        int m = grid.length;
        int n = grid[0].length;
        int d1[][] = new int[m][n];//top left to bottom right diagonal
        for(int r=0; r<m; r++) {
            for(int c=0; c<n; c++) {
                d1[r][c]=grid[r][c];
                if(r>0 && c>0) d1[r][c]+=d1[r-1][c-1];
            }
        }
        int d2[][] = new int[m][n];//top right to bottom left diagonal
        for(int r=0; r<m; r++) {
            for(int c=n-1; c>=0; c--) {
                d2[r][c]=grid[r][c];
                if(r>0 && c<n-1) d2[r][c]+=d2[r-1][c+1];
            }
        }
        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                set.add(grid[r][c]);
                for(int s=1; r-s>=0 && r+s<m && c-s>=0 && c+s<n; s++){
                    int sum = 0;
                    sum += d1[r][c+s]-(r-s-1>=0 && c-1>=0? d1[r-s-1][c-1] : 0);
                    sum += d2[r+s][c]-(r-1>=0 && c+s+1<n ? d2[r-1][c+s+1] : 0);
                    sum += d1[r+s][c]-(r-1>=0 && c-s-1>=0 ? d1[r-1][c-s-1] : 0);
                    sum += d2[r][c-s]-(r-s-1>=0 && c+1<n ? d2[r-s-1][c+1] : 0);
                    sum -= (grid[r-s][c]+grid[r][c+s]+grid[r+s][c]+grid[r][c-s]);

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