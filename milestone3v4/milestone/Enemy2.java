import edu.nd.cse.paradigms.*;

public class Enemy2 extends PESquare {
    protected int enemy2Direction;
    public Enemy2() { super(); enemy2Direction = -1;}
    public void tick() {
        // AUTO MOVE ENEMY2 LEFT AND RIGHT
        int enemy2X = this.getX();
        if (enemy2X >= 650 - 50) { enemy2Direction = -1;} 
        else if (enemy2X <= 40) { enemy2Direction = 1; }
        this.setCenter(enemy2X + enemy2Direction * 1, this.getY()); 
    }
}
