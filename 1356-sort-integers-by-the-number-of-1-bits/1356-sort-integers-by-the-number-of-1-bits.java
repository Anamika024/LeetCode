class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : arr) {
            int count = countOnesBits(num);
            map.put(num, count);
            // System.out.println(num + "->" + count);
        } 
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (a, b)-> {
            int compareValue = a.getValue().compareTo(b.getValue());
            if(compareValue!=0) {
                return compareValue;
            }
            return a.getKey().compareTo(b.getKey());
        });
        int i=0;
        for(Map.Entry<Integer, Integer> e : list) {
            arr[i++]=e.getKey();
        }
        return arr;
    }
    public int countOnesBits(int num) {
        int count=0;
        while(num>0) {
            int rem = num%2;
            if(rem==1) count++;
            num/=2;
        }
        return count;
    }
}