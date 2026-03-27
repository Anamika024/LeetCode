class Solution {
    int m, n;
    public boolean areSimilar(int[][] mat, int k) {
        m=mat.length;
        n=mat[0].length;
        int copy[][] = new int[m][];
        for(int i=0; i<m; i++) {
            copy[i]=mat[i].clone();
        }
        for(int i=0; i<k; i++) {
            cyclicShift(copy);
        }
        return isIdentical(mat, copy);
        
    }
    public void cyclicShift(int[][] mat) {
        for(int i=0; i<m; i++) {
            int start = mat[i][0];
            int end = mat[i][n-1];
            if(i%2==0) {
                for(int j=0; j<n; j++) {
                    mat[i][j]= j==n-1 ? start :  mat[i][j+1];
                }
            }else {
                for(int j=n-1; j>=0; j--) {
                    mat[i][j]= j==0 ? end :  mat[i][j-1];
                }
            }
        }
    }
    public boolean isIdentical(int[][] mat1, int[][] mat2) {
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(mat1[i][j]!=mat2[i][j]) return false;
            }
        }
        return true;
    }
}