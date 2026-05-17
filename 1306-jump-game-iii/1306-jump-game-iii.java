class Solution {
    public boolean canReach(int[] arr, int start) {
        if(start<0 || start>=arr.length || arr[start]<0) {
            return false;
        }
        if(arr[start]==0) {
            return true;
        }
        int jump = arr[start];
        arr[start]=-1;//marked as visited

        boolean right = canReach(arr, start+jump);
        boolean left = canReach(arr, start-jump);

        return left||right;
    }
}