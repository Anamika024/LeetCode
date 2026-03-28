class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        char[] word = new char[n];
        Arrays.fill(word, '$');
        for(int i=0; i<n; i++) {
            //word[i]
            for(int j=0; j<i; j++) {
                if(lcp[j][i]>0) {
                    word[i]=word[j];
                    break;
                }
            }
            if(word[i]=='$') {
                boolean used[] = new boolean[n];
                for(int j=0; j<i; j++) {
                    if(lcp[j][i]==0) {
                        used[word[j]-'a']=true;
                    }
                }
                for(int idx=0; idx<26; idx++) {
                    if(used[idx]==false) {
                        word[i]=(char)(idx+'a');
                        break;
                    }
                }
                if(word[i]=='$') return "";
            }
        }
        return checkLcp(word, lcp) ? new String(word) : "";
    }
    public boolean checkLcp(char[] word, int[][] lcp) {
        int n = lcp.length;
        for(int i=0; i<n; i++) {
            if(word[i]!=word[n-1]) {
                if(lcp[i][n-1]!=0 || lcp[n-1][i]!=0) return false;
            }else {
                if(lcp[i][n-1]!=1 || lcp[n-1][i]!=1) return false;
            }
        }

        for(int i=n-2; i>=0; i--) {
            for(int j=n-2; j>=0; j--) {
                if(word[i]==word[j]) {
                    if(lcp[i][j]!=1+lcp[i+1][j+1]) return false;
                }else {
                    if(lcp[i][j]!=0) return false;
                }

            }
        }
        return true;


    }
}