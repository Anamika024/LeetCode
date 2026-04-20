class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int i=0, j=n-1, max1=0, max2=0;
        while(j>=0) {
            if(colors[i]!=colors[j]) {
                max2=Math.max(max2, j-i);
            }
            j--;
        }
        j=n-1;
        while(i<n) {
            if(colors[i]!=colors[j]) {
                max2=Math.max(max2, j-i);
            }
            i++;
        }
        return Math.max(max1, max2);
        
        
    }
}