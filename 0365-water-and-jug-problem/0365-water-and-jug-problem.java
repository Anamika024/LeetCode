class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        if(x+y<target) return false;
        int g = gcd(x, y);
        return target%g==0;
    }
    public int gcd(int a, int b) {
        while(b!=0) {
            int r = a%b;
            a=b;
            b=r;
        }
        return a;

    }
}