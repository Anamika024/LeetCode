class Solution {
    public boolean checkOnesSegment(String s) {
        int count=0, sum=0;
        for(char ch : s.toCharArray()) {
            if(ch=='1') sum++;

        }
        for(char ch : s.toCharArray()) {
            if(ch=='1') {
                count++;
            }else {
                break;
            }
        }
        return count==sum;
    }
}