class Fancy {
    List<Long> list;
    int mod=1000000007;
    long add=0, multi=1;

    public Fancy() {
        list = new ArrayList<>();
    }
    public long pow(long a, long b) {
        if(b==0) return 1;
        long ans = pow(a, b/2);
        if(b%2==0) {
            return ans*ans%mod;
        }else {
            return (a % mod * ans % mod * ans % mod) % mod;
        }
    }
    public void append(int val) {
        long x = ((val - add + mod) % mod * pow(multi, mod - 2)) % mod;
        list.add(x);
    }
    
    public void addAll(int inc) {
        add=(add+inc)%mod;
    }
    
    public void multAll(int m) {
        multi=multi*m%mod;
        add=add*m%mod;

    }
    
    public int getIndex(int idx) {
       if (idx >= list.size()) return -1;

        long val = list.get(idx);
        val = (val * multi) % mod;
        val = (val + add) % mod;

        return (int) val;
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */