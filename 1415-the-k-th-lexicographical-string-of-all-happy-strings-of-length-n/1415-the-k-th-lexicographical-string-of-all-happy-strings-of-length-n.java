class Solution {
    // PriorityQueue<String> pq = new PriorityQueue<>();
    int count=0;
    String ans="";
    char[] chars = {'a','b','c'};
    public String getHappyString(int n, int k) {
        char[] chars = {'a','b','c'};
        solve(n, new StringBuilder(), k);
        // if(k>pq.size()) return "";
        // while(k-->1) {
        //     pq.poll();
        // }
        // return pq.poll();
        return ans;
    }
    public void solve(int n, StringBuilder sb, int k) {
        if(sb.length()==n) {
            // pq.add(sb.toString());
            count++;
            if(count==k) ans=sb.toString();
            return;
        }
        for(char c : chars) {
            if(sb.length()>0 && sb.charAt(sb.length()-1)==c) continue;
            sb.append(c);
            solve(n, sb, k);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}