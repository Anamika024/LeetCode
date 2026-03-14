class Solution {
    PriorityQueue<String> pq = new PriorityQueue<>();
    public String getHappyString(int n, int k) {
        char[] chars = {'a','b','c'};
        solve(n, new StringBuilder(), chars);
        if(k>pq.size()) return "";
        while(k-->1) {
            pq.poll();
        }
        return pq.poll();
    }
    public void solve(int n, StringBuilder sb, char[] chars) {
        if(sb.length()==n) {
            pq.add(sb.toString());
            return;
        }
        for(char c : chars) {
            if(sb.length()>0 && sb.charAt(sb.length()-1)==c) continue;
            sb.append(c);
            solve(n, sb, chars);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}