class Solution {
    class Pair {
        char node;
        int cost;

        Pair(char n, int c) {
            this.node=n;
            this.cost=c;
        }
    }
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {

        int n = original.length;
        List<List<Pair>> graph = new ArrayList<>();
        for(int i=0; i<26; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<n; i++) {
            int u= original[i]-'a';
            char v=changed[i];
            int w=cost[i];
            graph.get(u).add(new Pair(v, w));
        }
        int[][] dist = new int[26][26];
        for(int i=0; i<26; i++) {
            dist[i]=dijkstraAlgo(graph, (char) (i+'a'));
        }
        long result=0;

        for(int i=0; i<source.length(); i++) {
            int  src = source.charAt(i)-'a';
            int dest = target.charAt(i)-'a';
            if(src==dest) continue;
            if(dist[src][dest]==Integer.MAX_VALUE) return -1;
            result+=dist[src][dest];
        }
        return result;

    }
    public int[] dijkstraAlgo(List<List<Pair>> graph, char src) {
        int[] dist = new int[26];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src-'a']=0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost-b.cost);
        pq.add(new Pair(src, 0));

        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            char node = curr.node;
            int cost = curr.cost;

            if(cost>dist[node-'a']) continue;

            for(Pair next : graph.get(node-'a')) {
                if(cost+next.cost<dist[next.node-'a']) {
                    dist[next.node-'a'] = cost+next.cost;
                    pq.add(new Pair(next.node, cost+next.cost));
                }

            }
        }
        return dist;

    }
}