class Solution {
    public int totalWaviness(int num1, int num2) {
        int sum=0;
        for(int num=num1; num<=num2; num++) {
            sum+=countWaviness(num);
        }
        return sum;
        
    }
    public int countWaviness(int n) {
        if(n<=100) {
            return 0;
        }
        int count=0;
        int prev = n%10;
        n/=10;
        int curr = n%10;
        n/=10;

        while(n>0) {
            int next = n%10;
            if((prev>curr && curr<next) || (prev<curr && curr>next)) {
                count++;
            }
            prev=curr;
            curr=next;
            n/=10;
        }
        return count;
    }

}