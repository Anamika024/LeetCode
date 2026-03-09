class Solution {

    public String findDifferentBinaryString(String[] nums) {
        int n = nums[0].length();
        HashSet<String> set = new HashSet<>();
        for(String s : nums) {
            set.add(s);
        }
        StringBuilder sb = new StringBuilder();
        return solve(n, sb, set);

        
    }
    public String solve(int n, StringBuilder sb, HashSet<String> set) {
        if(sb.length()==n) {
            String str = sb.toString();
            if(!set.contains(str)) {
                return str;
            }else {
                return null;
            }
        }
        sb.append('0');
        String res = solve(n, sb, set);
        if(res!=null) return res;
        sb.deleteCharAt(sb.length()-1);

        sb.append('1');
        res = solve(n, sb, set);
        if(res!=null) return res;
        sb.deleteCharAt(sb.length()-1);

        return null;
        
    }
}