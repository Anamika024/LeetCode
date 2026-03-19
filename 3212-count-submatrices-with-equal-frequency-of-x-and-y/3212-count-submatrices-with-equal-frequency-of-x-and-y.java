class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count=0;
        int rowX[][] = new int[m][n];
        int rowY[][] = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j]=='X') {
                    rowX[i][j]= j==0 ? 1 : rowX[i][j-1]+1;
                    rowY[i][j]= j==0 ? 0 : rowY[i][j-1];
                }else if(grid[i][j]=='Y') {
                    rowY[i][j]= j==0 ? 1 : rowY[i][j-1]+1;
                    rowX[i][j]= j==0 ? 0 : rowX[i][j-1];
                }else {
                    rowY[i][j]= j==0 ? 0 : rowY[i][j-1];
                    rowX[i][j]= j==0 ? 0 : rowX[i][j-1];
                }
                // System.out.println(rowX[i][j] + " "+ rowY[i][j]);
            } 
            System.out.println();
        }
        for(int j=0; j<n; j++) {
            if(rowX[0][j]==rowY[0][j] && rowX[0][j]>0) count++;
        }
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                rowX[i][j]+=rowX[i-1][j];
                rowY[i][j]+=rowY[i-1][j];
                if(rowX[i][j]==rowY[i][j] && rowX[i][j]>0) count++;
            }
        }
        int colX[] = new int[m];
        int colY[] = new int[m];

        for(int i=0; i<m; i++) {
            if(grid[i][0]=='X') {
                colX[i]= i==0 ? 1 : colX[i-1]+1;
                colY[i]= i==0 ? 0 : colY[i-1];
            }else if(grid[i][0]=='Y') {
                colY[i]= i==0 ? 1 : colY[i-1]+1;
                colX[i]= i==0 ? 0 : colX[i-1];
            }else {
                colX[i]= i==0 ? 0 : colX[i-1];
                colY[i]= i==0 ? 0 : colY[i-1];
            }
            // System.out.println(colX[i] + " "+ colY[i]);
            if(colX[i]==colY[i] && colX[i]>0) count++;
        }
        return count;

    }
}