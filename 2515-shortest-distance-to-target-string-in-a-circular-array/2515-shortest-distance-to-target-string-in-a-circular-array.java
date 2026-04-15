class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(words[i].equals(target)) {
                list.add(i);
            }
        }
        if(list.size()==0) return -1;
        int min=n;
        for(int idx : list) {
            int diff = Math.abs(idx-startIndex);
            int leftMove = diff;
            int rightMove = n-diff;
            min=Math.min(min, Math.min(leftMove, rightMove));
        }
        return min;

    }
}