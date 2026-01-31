class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<int[]> list = new ArrayList<>();

        Arrays.sort(intervals, Comparator.comparingInt(col->col[0]));

        list.add(new int[]{intervals[0][0], intervals[0][1]}); 

        for(int i=1; i<n; i++) {
            int[] curr = list.get(list.size()-1);
            if(curr[1]>=intervals[i][0]) {
                curr[1]=Math.max(curr[1], intervals[i][1]);

            }else {
                list.add(new int[]{intervals[i][0], intervals[i][1]});
            }

        }
        int ans[][] = new int[list.size()][2];
        int idx=0;
        for(int[] arr : list) {
            ans[idx][0]=arr[0];
            ans[idx][1]=arr[1];
            idx++;
        }

        return ans;

        
    }
}