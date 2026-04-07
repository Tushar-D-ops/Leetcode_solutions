class Robot {
int x;
int y;
int maxright;
int maxup;
int dir;
int perimeter;
    public Robot(int width, int height) {
         x=0;
         y=0;
        maxright=width-1;
        maxup=height-1;
        dir=1;
        perimeter = 2 * (width + height) - 4;
    }
    
    public void step(int num) {
        if (perimeter == 0) return;

        int i = num % perimeter;

        // special full loop case
        if (i == 0 && num > 0) {

            // only direction changes if at origin
            if (x == 0 && y == 0)
                dir = 2; // South

            return;
        }
        // while(i<num){
        //     if((x==maxright && dir==1) || (x==0 && dir==3) || (y==0 && dir==2) ||(y==maxup && dir==0)){
        //         dir=(dir-1+4)%4;
        //     }
        //     if(dir==0){
        //         y=y+1;
        //     }
        //     if(dir==1) x=x+1;
        //     if(dir==2) y=y-1;
        //     if(dir==3) x=x-1;
        //     i++;
        // }
        while(i>0){
            if(dir==0){
                if(y+i > maxup){
                     i-=maxup-y;
                    y=maxup;
                   
                    dir=3;
                }
                else{
                    y=y+i;
                    i=0;
                }
            }
                if(dir==1){
                if(x+i > maxright){
                    i-=maxright-x;
                    x=maxright;
                    
                    dir=0;
                }
                else{
                    x=x+i;
                    i=0;
                }
            }
            if(dir==2){
                if(y-i < 0){
                    i-=y;
                    y=0;
                    dir=1;
                }
                else{
                    y=y-i;
                    i=0;
                }
            }
            if(dir==3){
                if(x-i < 0){
                    
                    i-=x;
                    x=0;
                    
                    dir=2;
                }
                else{
                    x=x-i;
                    i=0;
                }
            }
            
        }
    }
    
    public int[] getPos() {
        return new int[]{x,y};
    }
    
    public String getDir() {
        if(dir==0) return "North";
        if(dir==1) return "East";
        if(dir==2) return "South";
        if(dir==3) return "West";
        return "";
            }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */