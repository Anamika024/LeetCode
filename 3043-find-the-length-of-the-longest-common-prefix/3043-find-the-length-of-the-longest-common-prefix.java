class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<String> set = new HashSet<>();
        for(int num : arr1) {
            String str = String.valueOf(num);
            StringBuilder prefix = new StringBuilder();
            for(char ch : str.toCharArray()) {
                prefix.append(ch);
                set.add(prefix.toString());
            }
        }
        int max=0;
        for(int num : arr2) {
            String str = String.valueOf(num);
            StringBuilder prefix = new StringBuilder();
            for(char ch : str.toCharArray()) {
                prefix.append(ch);
                if(set.contains(prefix.toString())) {
                    max=Math.max(max, prefix.length());
                }
            }
        }
        return max;
    }
}