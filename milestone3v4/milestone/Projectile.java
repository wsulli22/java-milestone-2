import edu.nd.cse.paradigms.*;

public class Projectile extends PECircle {
    protected int projectileTargetX; 
    protected int projectileTargetY;
    protected boolean projectileFired; 
    protected double projectileSpeed;
    protected PEWorldObject player;
    protected PEWorldObject target;


    //SETUP FUNCTIONS
    public Projectile() { super(); projectileSpeed = 10.0; projectileFired = false;}
    public void setPlayer(PEWorldObject player) { this.player = player; }
    public void setTarget(PEWorldObject target) { this.target = target; }


    public void tick() {

        //MOVE PROJECTILE
        if (projectileFired) {
            double deltaX = projectileTargetX - this.getX();
            double deltaY = projectileTargetY - this.getY();
            double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY); 
            if (distance < projectileSpeed) { this.setCenter(projectileTargetX, projectileTargetY); projectileFired = false;}
            else {			
            double directionX = (deltaX / distance) * projectileSpeed;
            double directionY = (deltaY / distance) * projectileSpeed;
            this.setCenter((int)(this.getX() + directionX), (int)(this.getY() + directionY));
            } } else { resetProjectile(player.getX(), player.getY());
        }
    }

    //PROJECTILE HELPER FUNCTIONS
    public void fireProjectile(int targetX, int targetY) {
        if (!projectileFired) { projectileTargetX = targetX; projectileTargetY = targetY; projectileFired = true; }
    }
    public void resetProjectile(int playerX, int playerY) {if (!projectileFired) { this.setCenter(playerX, playerY);}}
    public boolean isProjectileFired() { return projectileFired;}
    
}
