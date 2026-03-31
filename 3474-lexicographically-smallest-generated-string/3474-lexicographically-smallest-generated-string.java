class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        char[] word = new char[n+m-1];
        boolean[] canChange = new boolean[n+m-1];
        Arrays.fill(word, '$');

        for(int i=0; i<n; i++) {
            if(str1.charAt(i)=='T') {
                int idx=i;
                for(int j=0; j<m; j++) {
                    if(word[idx]!='$' && word[idx]!=str2.charAt(j)) {
                        return "";
                    }
                    word[idx]=str2.charAt(j);
                    idx++;
                }
            }
        }

        for(int i=0; i<n+m-1; i++) {
            if(word[i]=='$') {
                word[i]='a';
                canChange[i]=true;
            }
        }

        for(int i=0; i<n; i++) {
            if(str1.charAt(i)=='F') {
                boolean changed=false;
                if(isSame(word, str2, i, m)) {
                    for(int k=i+m-1; k>=i; k--) {
                        if(canChange[k]) {
                            word[k]='b';
                            changed=true;
                            break;
                        }
                    }
                    if(!changed) return "";
                }
            }
        }
        return new String(word);

    }
    public boolean isSame(char[] word, String str2, int idx, int m) {
        for(int i=0; i<m; i++) {
            if(word[idx++]!=str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}