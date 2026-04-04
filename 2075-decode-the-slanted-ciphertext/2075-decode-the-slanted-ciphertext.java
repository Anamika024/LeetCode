class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int l = encodedText.length();
        int col = l/rows;
        StringBuilder sb = new StringBuilder();
        for(int c=0; c<col; c++) {
            for(int j=c; j<l; j+=(col+1)) {
                sb.append(encodedText.charAt(j));
            }
        }
        while(!sb.isEmpty() && sb.charAt(sb.length()-1)==' ') {
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
        
    }
}