import edu.nd.cse.paradigms.*;

public class Enemy1 extends PESquare {
    protected int enemy1Direction;
    public Enemy1() { super(); enemy1Direction = -1; }
    public void tick() {
        // AUTO MOVE ENEMY1 UP AND DOWN
        int enemy1Y = this.getY();  
        if (enemy1Y >= 480 - 50) { enemy1Direction = -1; } 
        else if (enemy1Y <= 40) { enemy1Direction = 1; }
        this.setCenter(this.getX(), enemy1Y + enemy1Direction * 1); 
    }  
}
