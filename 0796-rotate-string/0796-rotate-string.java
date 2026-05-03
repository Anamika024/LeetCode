class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()) return false;
        s=s+s;
        if(s.indexOf(goal)!=-1) return true;
        return false;
        // int n = s.length();
        // char[] ch = s.toCharArray();
        // while(n-->0) {
        //     rotate(ch);
        //     // System.out.print(new String(ch) + " ");
        //     if(new String(ch).equals(goal)) return true;
        // }
        // return false;
        
    }
    public void rotate(char[] arr) {
        int n = arr.length;
        char prev=arr[0];
        for(int i=n-1; i>=0; i--) {
            char curr=arr[i];
            arr[i]=prev;
            prev=curr;
        }
    }
}