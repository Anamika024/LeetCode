class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();
        for(String q : queries) {
            for(String d : dictionary) {
                if(isValid(q, d)) {
                    ans.add(q);
                    break;
                }
            }
        }
        return ans;
    }
    public boolean isValid(String s1, String s2) {
        int diff=0;
        for(int i=0; i<s1.length(); i++) {
            if(s1.charAt(i)!=s2.charAt(i)) {
                diff++;
                if(diff>2) return false;
            }
        }
        return true;
    }
}