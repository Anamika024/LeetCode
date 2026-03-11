class Solution {
    public int bitwiseComplement(int n) {
        if(n==0) return 1;
        String s = intToBinary(n);
        return binaryToInt(s);
    }
    public String intToBinary(int n) {
        StringBuilder sb = new StringBuilder();
        while(n>0) {
            int rem = n%2;
            if(rem==1) {
                sb.append('0');
            }else {
                sb.append('1');
            }
            n/=2;;
        }
        return sb.toString();
    }  
    public int binaryToInt(String s) {
        int res=0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            res+= c=='1' ? Math.pow(2, i) : 0;
        }
        return res;
    } 
}