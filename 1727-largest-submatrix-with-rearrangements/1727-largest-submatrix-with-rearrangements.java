class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int j=0; j<n; j++) {
            for(int i=1; i<m; i++) {
                if(matrix[i][j]==1) {
                    matrix[i][j]+=matrix[i-1][j];
                }
            }
        }
        int max=0;
        for(int i=0; i<m; i++) {
            Arrays.sort(matrix[i]);
            for(int j=n-1; j>=0; j--) {
                max=Math.max(max, matrix[i][j]*(n-j));//width=n-j,ht=mat[i][j]
            }
        }
        return max;
    }
}