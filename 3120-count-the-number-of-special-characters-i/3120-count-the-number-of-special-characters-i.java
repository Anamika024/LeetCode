class Solution {
    public int numberOfSpecialChars(String word) {
        int lowerFreq[] = new int[26];
        int upperFreq[] = new int[26];

        for(char c : word.toCharArray()) {
            if(Character.isLowerCase(c)) {
                lowerFreq[c-'a']++;
            }else {
                upperFreq[c-'A']++;
            }
        }
        int count=0;
        for(int i=0; i<26; i++) {
            if(lowerFreq[i]>0 && upperFreq[i]>0) {
                count++;
            }
        }
        return count;
    }
}