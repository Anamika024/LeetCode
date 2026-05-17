class Solution {
    public boolean canReach(int[] arr, int start) {
        return canReach(arr, start, new boolean[arr.length]);

    }
    public boolean canReach(int[] arr, int i, boolean[] visited) {
        if(i<0 || i>=arr.length || visited[i]) {
            return false;
        }
        if(arr[i]==0) {
            return true;
        }
        visited[i]=true;
        
        boolean right = canReach(arr, i+arr[i], visited);
        boolean left = canReach(arr, i-arr[i], visited);
        
        return left || right;
    }
}