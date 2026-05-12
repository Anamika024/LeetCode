class Solution {
    public int minimumEffort(int[][] tasks) {
        int n = tasks.length;
        int[][] mat = new int[n][3];
        Arrays.sort(tasks, (a, b) -> Integer.compare(b[1], a[1]));
        for(int i=0; i<n; i++) {
            mat[i][0]=tasks[i][0];
            mat[i][1]=tasks[i][1];
            mat[i][2]=Math.abs(tasks[i][1]-tasks[i][0]);
        }
        Arrays.sort(mat, (a, b) -> Integer.compare(b[2], a[2]));

        int maxStart = tasks[0][1];

        int sum1=0, sum2=0;
        for(int task[] : tasks) {
            sum1+=task[0];
            sum2+=task[1];
        }
        // if(maxStart>=sum1) {
        //     return maxStart;
        // } 

        for(int e=sum1; e<=sum2; e++) {
            // System.out.println(isValid(e, tasks) + " " + e);
            if(isValid(e, mat)) {
                return e;
            }
        } 
        return sum2;
    }
    public boolean isValid(int energy, int[][] tasks) {
        for(int task[] : tasks) {
            if(energy<task[1]) {
                return false;
            }else {
                // System.out.println(energy);
                energy-=task[0];
            }
        }
        return true;
    }
}