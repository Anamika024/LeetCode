class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m=boxGrid.length;
        int n=boxGrid[0].length;
        char[][] res = new char[n][m];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                res[j][m-i-1]=boxGrid[i][j];
            }
        }
        for(int col=0; col<m; col++) {
            int emptyRow=n-1; // empty row from bottom
            for(int row=n-1; row>=0; row--) {
                if(res[row][col]=='*') {
                    emptyRow=row-1;
                    continue;
                }else if(res[row][col]=='#') {
                    res[row][col]='.';
                    res[emptyRow][col]='#';
                    emptyRow--;
                }
            }
        }
        return res;  
    }
}