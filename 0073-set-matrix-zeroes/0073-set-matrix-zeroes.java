class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j]==0) {
                    list.add(new int[]{i, j});
                }
            }
        }
        for(int idx=0; idx<list.size(); idx++) {
            int r = list.get(idx)[0], c = list.get(idx)[1];
            for(int j=0; j<n; j++) {
                matrix[r][j]=0;
            }
            for(int i=0; i<m; i++) {
                matrix[i][c]=0;
            }
        }
    }
}