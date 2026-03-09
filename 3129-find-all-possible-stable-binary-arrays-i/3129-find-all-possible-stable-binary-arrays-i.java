class Solution {
    int mod = 1000000007;
    int dp[][][];
    public int numberOfStableArrays(int zero, int one, int limit) {
        dp = new int[201][201][2];
        for(int i=0; i<201; i++) {
            for(int j=0; j<201; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        int startWithOne = solve(zero, one, 0, limit);
        int startWithZero = solve(zero, one, 1, limit);

        return (startWithOne+startWithZero)%mod;

    }
    public int solve(int zerosLeft, int onesLeft, int lastWasOne, int limit) {
        if(onesLeft==0 && zerosLeft==0) {
            return 1;
        }
        if(dp[zerosLeft][onesLeft][lastWasOne]!=-1) {
            return dp[zerosLeft][onesLeft][lastWasOne];
        }
        int result=0;

        if(lastWasOne==1) { //explore 0's
            for(int len=1; len<=Math.min(zerosLeft, limit); len++) {
                result = (result+solve(zerosLeft-len, onesLeft, 0, limit))%mod;
            }
        }else {// explore 1's
            for(int len=1; len<=Math.min(onesLeft, limit); len++) {
                result = (result+solve(zerosLeft, onesLeft-len, 1, limit))%mod;
            }
        }

        return dp[zerosLeft][onesLeft][lastWasOne]=result;

    }
}