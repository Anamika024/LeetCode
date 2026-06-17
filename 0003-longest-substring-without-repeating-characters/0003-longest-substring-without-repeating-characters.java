class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();

        int l=0, max=0;
        for(int r=0; r<n; r++) {
            char c = s.charAt(r);

            while(set.contains(c)) {//if duplicate char, shrink window from left&remove left char from set also
                set.remove(s.charAt(l));
                l++;
            }
            set.add(c);
            max = Math.max(max, r-l+1);

        }
        return max;
        
    }
}