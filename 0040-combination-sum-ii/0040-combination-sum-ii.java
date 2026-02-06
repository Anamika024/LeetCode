class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.ans= new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        solve(candidates, 0, target, path);
        return ans;
    }
    public void solve(int[] arr, int idx, int target, List<Integer> path) {
        if(target==0) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i=idx; i<arr.length; i++) {
            if(i>idx && arr[i]==arr[i-1]) continue; //skip duplicate combination
            if(arr[i]>target) break; // can't make combination with arr[i]
            path.add(arr[i]);
            solve(arr, i+1, target-arr[i], path);
            path.remove(path.size()-1);
        }


    }
}