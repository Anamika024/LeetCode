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
            for(int row=n-1; row>=0; row--) {
                if(res[row][col]=='.') {
                    int startRow=-1;
                    for(int k=row-1; k>=0; k--) {
                        if(res[k][col]=='*') {
                            break;
                        }else if(res[k][col]=='#') {
                            startRow=k;
                            break;
                        }
                    }

                    if(startRow!=-1) {
                        res[row][col]='#';
                        res[startRow][col]='.';
                    }
                }
            }
        }
        return res;  
    }
}