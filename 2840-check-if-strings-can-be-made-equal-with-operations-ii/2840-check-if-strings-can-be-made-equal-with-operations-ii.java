class Solution {
    public boolean checkStrings(String s1, String s2) {
        int n = s1.length();
        if(n==1) return s1.equals(s2);
        char[] even1 = new char[(n+1)/2];
        char[] odd1 = new char[n/2];

        char[] even2 = new char[(n+1)/2];
        char[] odd2 = new char[n/2];
        int e=0, o=0;

        for(int i=0; i<n; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if(i%2==0) {
                even1[e]=c1;
                even2[e]=c2;
                e++;
            }else {
                odd1[o]=c1;
                odd2[o]=c2;
                o++;
            }
        }
        Arrays.sort(even1);
        Arrays.sort(odd1);
        Arrays.sort(even2);
        Arrays.sort(odd2);

        return Arrays.equals(even1, even2) && Arrays.equals(odd1, odd2);

        
    }
}