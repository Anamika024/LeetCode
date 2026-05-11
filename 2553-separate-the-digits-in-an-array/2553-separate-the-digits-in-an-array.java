class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int size=0;
        for(int num : nums) {
            int rev=0;
            while(num>0) {
                int rem = num%10;
                rev=rev*10+rem;
                num/=10;
                size++;
            }
            while(rev>0) {
                int rem = rev%10;
                list.add(rem);
                rev/=10;
            }
            while(list.size()<size) {
                list.add(0);
            }

        }
        int ans[] = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            ans[i]=list.get(i);
        }
        return ans;
        
    }
}