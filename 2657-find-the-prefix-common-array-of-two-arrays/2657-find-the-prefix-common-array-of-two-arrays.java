class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] c = new int[n];
        boolean[] checkA = new boolean[n+1];
        boolean[] checkB = new boolean[n+1];
        for(int i=0; i<n; i++) {
            checkA[A[i]]=true;
            checkB[B[i]]=true;
            if(A[i]==B[i]) {
                c[i]= (i==0 ? 0 : c[i-1])+1;
            }else {
                int count=0;
                for(int j=1; j<=n; j++) {
                    if(checkA[j] && checkB[j]) count++;
                }
                if(count!=0) {
                    c[i]=count;
                }else {
                    c[i]=(i==0 ? 0 : c[i-1]);
                }
            }
        }
        return c;


        
    }
}