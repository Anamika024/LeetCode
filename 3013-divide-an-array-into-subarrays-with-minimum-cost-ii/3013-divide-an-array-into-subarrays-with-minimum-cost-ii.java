class Solution {
    TreeMap<Integer, Integer> s = new TreeMap<>(); // k-1 smallest
    TreeMap<Integer, Integer> b = new TreeMap<>(); // rest
    long sum = 0;
    int sizeS = 0;
    int k;


    public long minimumCost(int[] nums, int k, int dist) {
                this.k = k;
        int n = nums.length;

        // initial window [1 .. 1+dist]
        int l = 1, r = 1 + dist;
        for (int i = l; i <= r; i++) {
            add(nums[i]);
        }

        long ans = sum;
        while (r + 1 < n) { // slide window
            remove(nums[l]);
            l++;
            r++;
            add(nums[r]);
            ans = Math.min(ans, sum);
        }

        return ans + nums[0];
    }
    void balance() {
        while (sizeS > k - 1) {
            int x = s.lastKey();
            removeFromMap(s, x);
            sizeS--;
            sum -= x;
            addToMap(b, x);
        }
        while (sizeS < k - 1 && !b.isEmpty()) {
            int x = b.firstKey();
            removeFromMap(b, x);
            addToMap(s, x);
            sizeS++;
            sum += x;
        }
    }

    void add(int x) {
        if (s.isEmpty() || x <= s.lastKey()) {
            addToMap(s, x);
            sizeS++;
            sum += x;
        } else {
            addToMap(b, x);
        }
        balance();
    }

    void remove(int x) {
        if (s.containsKey(x)) {
            removeFromMap(s, x);
            sizeS--;
            sum -= x;
        } else {
            removeFromMap(b, x);
        }
        balance();
    }
    void addToMap(TreeMap<Integer, Integer> map, int x) {
        map.put(x, map.getOrDefault(x, 0) + 1);
    }

    void removeFromMap(TreeMap<Integer, Integer> map, int x) {
        int cnt = map.get(x);
        if (cnt == 1) map.remove(x);
        else map.put(x, cnt - 1);
    
    }
}