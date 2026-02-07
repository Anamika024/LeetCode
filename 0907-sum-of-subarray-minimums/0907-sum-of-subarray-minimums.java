class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length, sum=0;
        int mod = 1000000007;
        int[] ps = prevSmaller(arr);
        int[] ns = nextSmaller(arr);

        for(int i=0; i<n; i++) {
            int left = i-ps[i];
            int right = ns[i]-i;
            sum = (int)(sum+((long)left*right*arr[i])%mod)%mod;
        }
        return sum;
    }
    public int[] prevSmaller(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] ans = new int[n];
        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && arr[st.peek()]>arr[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;

    }
     public int[] nextSmaller(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] ans = new int[n];
        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;

    }
}