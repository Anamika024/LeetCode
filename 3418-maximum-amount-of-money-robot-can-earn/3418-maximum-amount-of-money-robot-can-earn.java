class Solution {
    Integer dp[][][];
    public int maximumAmount(int[][] coins) {
        int m=coins.length, n = coins[0].length;
        dp=new Integer[m][n][3];
        return path(coins, 0, 0, 0);
    }
    public int path(int[][] coins, int i, int j, int count) {
        if(i>=coins.length || j>=coins[0].length) {
            return Integer.MIN_VALUE;
        }
        if(i==coins.length-1 && j==coins[0].length-1) {
            if (coins[i][j]<0 && count<2) return dp[i][j][count]=0; 
            return dp[i][j][count]=coins[i][j];
        }
        if (dp[i][j][count] != null) {
            return dp[i][j][count];
        }


        if(coins[i][j]>=0) {
            dp[i][j][count]= coins[i][j]+Math.max(path(coins, i+1, j, count), path(coins, i, j+1, count));
        }else {
            int take = coins[i][j]+Math.max(path(coins, i+1, j, count), path(coins, i, j+1, count));
            int skip = Integer.MIN_VALUE;
            if (count<2) {
                skip = Math.max(
                    path(coins, i+1, j, count+1),
                    path(coins, i, j+1, count+1)
                );
            }

            dp[i][j][count]= Math.max(take, skip);
        }
        return dp[i][j][count];
    }
}