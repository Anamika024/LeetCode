class Solution {
    public int maxNumberOfBalloons(String text) {
        int freq[] = new int[26];
        for(char c : text.toCharArray()) {
            freq[c-'a']++;
        }

        int aFreq = freq[0], bFreq=freq[1], lFreq=freq[11], nFreq=freq[13], oFreq=freq[14];

        //single char ->a, b, n, paired char-> l, o

        int singleMin = Math.min(aFreq, Math.min(bFreq, nFreq));
        int pairedMin = Math.min(lFreq, oFreq);

        return Math.min(singleMin, pairedMin/2);

        
    }
}