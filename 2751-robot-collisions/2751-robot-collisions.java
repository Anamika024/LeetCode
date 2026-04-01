class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer index[] = new Integer[n];
        for(int i=0; i<n; i++) {
            index[i]=i;
        }

        Arrays.sort(index, (a, b) -> Integer.compare(positions[a], positions[b]));

        List<Integer> result = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        for (int curr : index) {
            if (directions.charAt(curr) == 'R') {
                st.push(curr);
            } else {
                while (!st.isEmpty() && healths[curr] > 0) {
                    int top = st.pop();

                    if (healths[top] > healths[curr]) {
                        healths[top] -= 1;
                        healths[curr] = 0;
                        st.push(top);
                    } else if (healths[top] < healths[curr]) {
                        healths[curr] -= 1;
                        healths[top] = 0;
                    } else {
                        healths[curr] = 0;
                        healths[top] = 0;
                    }
                }
            }
        }

        for (int health : healths) {
            if (health > 0) {
                result.add(health);
            }
        }
        return result;


    }
}