package edu.nd.cse.paradigms;

//NEW: public class PECircle
public class PECircle{
    private int x, y;
    private int radius;

    //NEW: public PECicle()
    public PECircle(){
        this.x = 0;
        this.y = 0;
        this.radius = 10;
    }   

    //NEW: public void setRadius(int radius)
    public void setRadius(int radius){
        this.radius = radius;
    }

    //NEW: public void tick()
    public void tick(){}    

    //NEW: public boolean inObjectBoundary(int qx, int qy)
    public boolean inObjectBoundary(int qx, int qy){
        return Math.sqrt(Math.pow(qx - this.x, 2) + Math.pow(qy - this.y, 2)) <= this.radius;
    }

    //NEW: public void render(PEScreen screen)
    public void render(PEScreen screen){
        screen.fillCircle(this.x, this.y, this.radius);
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
