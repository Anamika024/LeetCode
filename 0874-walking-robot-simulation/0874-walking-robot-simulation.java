class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};//n->e->s->w
        int dir=0;

        int x=0, y=0, maxDist=0;
        Set<String> set = new HashSet<>();
        for(int[] ob : obstacles) {
            set.add(ob[0] + "," + ob[1]);
        }

        for(int c : commands) {
            if(c==-2) {
                dir=(dir+3)%4; //left
            }else if(c==-1) {
                dir=(dir+1)%4; //right
            }else if(c>=1 && c<=9) {
                for(int i=0; i<c; i++) {
                    int nx = x+dirs[dir][0];
                    int ny = y+dirs[dir][1];
                    if(set.contains(nx + "," + ny)) {
                        break; // obstacle found
                    }
                    x = nx;
                    y = ny;
                    maxDist = Math.max(maxDist, x*x + y*y);
                }

            }
        }
        return maxDist;
        
    }

}