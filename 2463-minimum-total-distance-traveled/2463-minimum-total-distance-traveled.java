class Solution {
    private long solve(int r, int f, List<Integer> robot, List<Integer> positions, long[][] memo) {
        if(r>=robot.size()) {
            return 0; // No more distance to be covered
        }
        if(f>= positions.size()) {
            return (long) 1e12; // Large value representing an infeasible solution
        }
        if(memo[r][f] != -1) {
            return memo[r][f];
        }

        long take = Math.abs(robot.get(r)-positions.get(f))+solve(r+1, f+1, robot, positions, memo);
        long skip = solve(r, f+1, robot, positions, memo);

        return memo[r][f] = Math.min(take, skip);
    }

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));
        int m = robot.size();

        // Expand factory positions to avoid tracking of limit and easy recursion
        List<Integer> positions = new ArrayList<>();
        for (int[] f : factory) {
            int pos = f[0];
            int limit = f[1];
            for (int j = 0; j < limit; j++) {
                positions.add(pos);
            }
        }
        int n = positions.size();
        long[][] memo = new long[m + 1][n + 1];
        for (long[] row : memo) {
            Arrays.fill(row, -1);
        }
        return solve(0, 0, robot, positions, memo);
    }
}