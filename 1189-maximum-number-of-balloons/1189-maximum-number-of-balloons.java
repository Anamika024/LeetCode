class Solution {
    public int maxNumberOfBalloons(String text) {
        int freq[] = new int[26];
        for(char c : text.toCharArray()) {
            freq[c-'a']++;
        }

        int b = freq['b'-'a'];
        int a = freq['a'-'a'];
        int l = freq['l'-'a'];
        int o = freq['o'-'a'];
        int n = freq['n'-'a'];

        //single char ->a, b, n, double char-> l, o

        int singleMin = Math.min(a, Math.min(b, n));
        int doubleMin = Math.min(l, o);

        return Math.min(singleMin, doubleMin/2);

        
    }
}