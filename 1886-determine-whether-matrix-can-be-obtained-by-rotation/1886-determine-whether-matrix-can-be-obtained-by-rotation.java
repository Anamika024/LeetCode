class Solution {
    int n;
    public boolean findRotation(int[][] mat, int[][] target) {
        n=mat.length;
        if(isSame(mat, target)) return true;
        if(isSame(rotate90(mat), target)) return true;
        if(isSame(rotate90(rotate90(mat)), target)) return true;
        if(isSame(rotate90(rotate90(rotate90(mat))), target)) return true;
        return false;

        
    }
    public int[][] rotate90(int[][] mat) {
        int rotate[][] = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                rotate[j][n-i-1]=mat[i][j];
            }
        }
        return rotate;
    }
    public boolean isSame(int[][] mat, int[][] target) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(mat[i][j]!=target[i][j]) return false;
            }
        }
        return true;
    }
}