class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        if(n<3) return -1;
        ArrayList<Integer>[] arr = new ArrayList[101];
        for(int i=0; i<101; i++) {
            arr[i]=new ArrayList<>();
        }

        for(int i=0; i<n; i++) {
            int idx=nums[i];
            arr[idx].add(i);
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<101; i++) {
            int size = arr[i].size();
            int dist=0;
            if(size>=3) {
                for(int j=0; j<size-2; j++) {
                    int a = arr[i].get(j);
                    int b = arr[i].get(j+1);
                    int c = arr[i].get(j+2);
                    dist = Math.abs(a-b)+Math.abs(b-c)+Math.abs(c-a);
                    min=Math.min(min, dist);
                }
            }
        }
        return min==Integer.MAX_VALUE ? -1 : min;
        
    }
}