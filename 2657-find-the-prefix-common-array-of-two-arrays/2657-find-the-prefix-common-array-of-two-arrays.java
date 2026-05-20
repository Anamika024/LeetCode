class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] c = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0)+1);
            map.put(B[i], map.getOrDefault(B[i], 0)+1);
            if(A[i]==B[i]) {
                c[i]= (i==0 ? 0 : c[i-1])+1;
            }else {
                int count=0;
                for(int key : map.keySet()) {
                    if(map.get(key)==2) count++;
                }
                c[i]=count;
                // if(count!=0) {
                //     c[i]=count;
                // }else {
                //     c[i]=(i==0 ? 0 : c[i-1]);
                // }
            }
        }
        return c;


        
    }
}