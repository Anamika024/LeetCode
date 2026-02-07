class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n==0 || n==1) return n;
        int l=0, r=1, maxLen=0;
        while(r<=n) {
            if(isUnique(s.substring(l, r))) {
                maxLen=Math.max(maxLen, r-l);
            }else {
                l++;
            }
            r++;

        }
        return maxLen;

    }
    public boolean isUnique(String s) {
        Set<Character> set = new HashSet<>();
        for(char ch : s.toCharArray()) {
            set.add(ch);
        }
        return set.size()==s.length();
    }
}