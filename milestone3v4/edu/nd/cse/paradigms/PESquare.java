package edu.nd.cse.paradigms;

public class PESquare extends PEWorldObject {
    private int size;

    //public PESquare()
    public PESquare() { this.size = 30; }

    //public void tick()
    public void tick() {}

    //public void setSize(int size)
    public void setSize(int size) {this.size = size;}

    //NEW: boolean inObjectBoundary(int qx, int qy)
    public boolean inObjectBoundary(int qx, int qy){
        return (qx >= this.x - size / 2 && qx <= this.x + size / 2) &&    //CODE ADDED
        (qy >= this.y - size / 2 && qy <= this.y + size / 2);             //CODE ADDED
    }


    //public void render(PEScreen screen)
    public void render(PEScreen screen) {
        for (int x1 = -size / 2; x1 < size / 2; x1++) {
            for (int y1 = -size / 2; y1 < size / 2; y1++) {
                screen.setPixel(x + x1, y + y1, color);
            }
        }
    }
}
