class Solution {
    public boolean checkOnesSegment(String s) {
        if(s.contains("01")) return false;
        return true;
        // int count=0, sum=0;
        // for(char ch : s.toCharArray()) {
        //     if(ch=='1') sum++;

        // }
        // for(char ch : s.toCharArray()) {
        //     if(ch=='1') {
        //         count++;
        //     }else {
        //         break;
        //     }
        // }
        // return count==sum;
    }
}