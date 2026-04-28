class Solution {
    public int minOperations(int[][] grid, int x) {
        int m=grid.length, n=grid[0].length;
        if(m*n==1) return 0;
        int arr[] = new int[m*n];
        int idx=0;
        for(int row[] : grid) {
            for(int val : row) {
                arr[idx++]=val;
            }
        }
        Arrays.sort(arr);
        int median = arr[(m*n)/2];
        int ans=0;
        for(int row[] : grid) {
            for(int val : row) {
                if(Math.abs(val-median)%x!=0) return -1;
                ans+=Math.abs(val-median)/x;
            }
        }
        return ans;

        


        
    }
}