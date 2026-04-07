class Robot {
    int idx=0;
    boolean moved=false;
    List<List<Integer>> pos =  new ArrayList<>();
    public Robot(int width, int height) {
        for(int x=0; x<width; x++) {// y=0, east
            pos.add(Arrays.asList(x, 0, 0));
        }
        for(int y=1; y<height; y++) {// x=w-1, north
            pos.add(Arrays.asList(width-1, y, 1));
        }
        for(int x=width-2; x>=0; x--) {// y=h-1, west
            pos.add(Arrays.asList(x, height-1, 2));
        }
        for(int y=height-2; y>0; y--) {// x=0, south
            pos.add(Arrays.asList(0, y, 3));
        }
        pos.get(0).set(2, 3); // changing dir south

    }
    
    public void step(int num) {
        moved=true;
        idx=(idx+num)%pos.size();
    }
    
    public int[] getPos() {
        if(!moved) return new int[]{0, 0};
        return new int[]{pos.get(idx).get(0), pos.get(idx).get(1)};
        
    }
    
    public String getDir() {
        if(!moved) return "East";
        if(pos.get(idx).get(2)==0) {
            return "East";
        }else if(pos.get(idx).get(2)==1) {
            return "North";
        }else if(pos.get(idx).get(2)==2) {
            return "West";
        }else {
            return "South";
        }
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */