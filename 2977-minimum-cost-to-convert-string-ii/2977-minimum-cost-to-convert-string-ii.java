class Solution {
    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        int n = source.length();

        // Step 1: Assign IDs to all unique strings
        Map<String, Integer> id = new HashMap<>();
        int idx = 0;

        for (String s : original)
            if (!id.containsKey(s)) id.put(s, idx++);
        for (String s : changed)
            if (!id.containsKey(s)) id.put(s, idx++);

        int m = idx;
        long[][] dist = new long[m][m];

        for (int i = 0; i < m; i++)
            Arrays.fill(dist[i], Long.MAX_VALUE/2);

        for (int i = 0; i < m; i++)
            dist[i][i] = 0;

        // Step 2: Initialize edges
        for (int i = 0; i < original.length; i++) {
            int u = id.get(original[i]);
            int v = id.get(changed[i]);
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        // Floyd–Warshall
        for (int k = 0; k < m; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Group original strings by length
        Map<Integer, List<String>> byLen = new HashMap<>();
        for (String s : original) {
            if (!byLen.containsKey(s.length())) {
                byLen.put(s.length(), new ArrayList<>());
            }
            byLen.get(s.length()).add(s);
            // byLen.computeIfAbsent(s.length(), k -> new ArrayList<>()).add(s);
        }

        // Step 3: DP
        long[] dp = new long[n+1];
        Arrays.fill(dp, Long.MAX_VALUE/2);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            // Single character match
            if (source.charAt(i-1) == target.charAt(i-1)) {
                dp[i] = dp[i-1];
            }

            // Substring transforms
            for (int len : byLen.keySet()) {
                if (i-len < 0) continue;

                String s1 = source.substring(i-len, i);
                String s2 = target.substring(i-len, i);

                Integer s= id.get(s1);
                Integer t = id.get(s2);

                if (s != null && t != null && dist[s][t] < Long.MAX_VALUE/2) {
                    dp[i] = Math.min(dp[i], dp[i-len] + dist[s][t]);
                }
            }
        }

        return dp[n] >= Long.MAX_VALUE/2 ? -1 : dp[n];
        
    }
}