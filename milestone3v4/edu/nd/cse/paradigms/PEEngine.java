package edu.nd.cse.paradigms;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List; 
import java.awt.event.KeyEvent;


//public class PEEngine
public class PEEngine extends Frame{
    protected PEGame game;
    protected PEScreen screen;
    protected List<PEWorldObject> worldObjects;
    protected int width = 640;
    protected int height = 480;
    protected int titlebarHeight = 0; // varies by OS
    
    //public PEEngine(PEGame game)
    public PEEngine(PEGame game){
        this.game = game;
        this.screen = new PEScreen(width, height);
        this.worldObjects = new ArrayList<>(); 
        screen.clear();
        setSize(width, height + titlebarHeight);
        setVisible(true);
        PECentralClock clock = new PECentralClock(this, 50);
    } 

    //NEW: private void processEvent(PEKeyEven evt)
    private void processEvent(PEKeyEvent evt){}

    //NEW: private void eventLoopInterate()

    //NEW: keyPressed(KeyEvent evt) 
    public void keyPressed(KeyEvent evt){}

    //NEW: keyReleased(KeyEvent evt)
    public void keyReleased(KeyEvent evt){}

    //NEW: keyTyped (KeyEvent evt)
    public void keyTyped(KeyEvent evt){}

    //public void add(PEWorldObject wo)
    public void add(PEWorldObject wo){ worldObjects.add(wo); }

    //public void remove(PEWorldObject wo)
    public void remove(PEWorldObject wo) { worldObjects.remove(wo); }

    //NEW: public boolean dectectCollision(PEWorldObject wo1, PEWorldObject wo2)
    public boolean dectectCollision(PEWorldObject wo1, PEWorldObject wo2){
        
    }

    //public void tick()
    public void tick() {

        //NEW: "on every tick, call detectCllision() on eary pair of PEWorldObjects in the list of world objects"
        detectCollision();
        

        this.screen.clear();
        for (PEWorldObject wo : worldObjects) {
            wo.tick();
            wo.render(screen);
        }
        this.repaint();
    }

    //public void update(Graphics g)
    public void update(Graphics g){ paint(g); }

    //public void paint(Graphics g)
    public void paint(Graphics g){ 
        g.drawImage(screen.render(), 0, titlebarHeight, width, height, Color.BLACK, null); 
    }
    //NEW: code inside added
    public boolean detectCollision(PEWorldObject wo1, PEWorldObject wo2) {
        int x1 = wo1.getX();
        int y1 = wo1.getY();
        int[] size1 = wo1.getSize();
        int width1 = size1[0];
        int height1 = size1[1];

        int x2 = wo2.getX();
        int y2 = wo2.getY();
        int[] size2 = wo2.getSize();
        int width2 = size2[0];
        int height2 = size2[1];

        // Check for overlap
        if (x1 < x2 + width2 && x2 < x1 + width1 &&
            y1 < y2 + height2 && y2 < y1 + height1) {
            return true;  // Collision detected
        }

        return false;  // No collision
    }
}
