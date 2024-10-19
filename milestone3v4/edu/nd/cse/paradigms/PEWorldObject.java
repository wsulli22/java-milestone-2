package edu.nd.cse.paradigms;

//abstract public class PEWorldObject
abstract public class PEWorldObject {
    protected int x;
    protected int y;
    protected int color;

    //public PEWorldObject()
    public PEWorldObject() { this.x = 0; this.y = 0; this.color = 0; }
    //public void setCenter(int x, int y)
    public void setCenter(int x, int y) { this.x = x; this.y = y; }
    
    //public void setColor(int color)
    public void setColor(int color) {this.color = color;}

    //public int getX()
    public int getX() { return x; }

    //public int getY()
    public int getY() { return y; }

    //public abstract void tick();
    public abstract void tick();

    //public abstract void render(PEScreen screen);
    public abstract void render(PEScreen screen);
}
