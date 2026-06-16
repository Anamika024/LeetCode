class Solution {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()) {
            if(Character.isLetter(c)) {
                sb.append(c);
            }else if(c=='*') {
                if(sb.length()>0) {
                    sb.deleteCharAt(sb.length()-1);
                }
            }else if(c=='#') {
                sb.append(sb);
            }else if(c=='%') {
                sb.reverse();
            }
        }
        return sb.toString();
    }
}