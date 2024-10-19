import edu.nd.cse.paradigms.*;
import java.util.List;

public class MyGame extends PEGame {

    // GLOBAL VARIABLES
    protected PEEngine engine;
    protected PECircle player;
    protected Enemy1 enemy1;
    protected Enemy2 enemy2;
    protected Target target;
    protected Projectile projectile;
    protected int enemy1Direction;
    protected int enemy2Direction;
    protected int difficulty;
    protected int hitNumberEnemy1;
    protected int hitNumberEnemy2;
    protected boolean enemy1Hit;
    protected boolean enemy2Hit;
    protected PowerupObject powerupobject; //ADDED AS PART OF SECOND MILESTONE

	// INITALIZATION FUNCTIONS
    public void start() {
        this.engine = new PEEngine(this, 50);
		System.out.printf("\n\n\n");

        // SET DIFFICULTY
        difficulty = 1;   // 3 = HARD | 2 = MEDIUM | 1 = EASY
						  // STRATEGY PATTERN USED IN COLLSION FILE
        
        // PLAYER
        player = new PECircle();
        player.setRadius(20);
		player.setCenter(590, 440);
        player.setColor(0x41b3cc);
        engine.add(player);

        // ENEMY 1
        enemy1 = new Enemy1();
        enemy1.setSize(50);
        enemy1.setCenter(590, 50);
        enemy1Direction = -1;
        enemy1.setColor(0xcf03fc);
        engine.add(enemy1);

        // ENEMY 2
        enemy2 = new Enemy2();
        enemy2.setSize(50);
        enemy2.setCenter(50, 430);
        enemy2.setColor(0xcf03fc);
        enemy2Direction = -1;
        engine.add(enemy2);

        // TARGET
        target = new Target();
        target.setSize(10);
		target.setCenter(500, 350);
        target.setColor(0x41b3cc);
        engine.add(target);

        // PROJECTILE
        projectile = new Projectile();
        projectile.setRadius(5);
        projectile.setCenter(player.getX(), player.getY());
        projectile.setPlayer(player); 
        projectile.setTarget(target); 
        engine.add(projectile);
        projectile.setColor(0x41b3cc);


        // POWER-UP OBJECT (ADDED AS PART OF SECOND MILESTONE)
        powerupobject = new PowerupObject();
        powerupobject.setSize(10);
        powerupobject.setCenter(-20, -20);
        powerupobject.setColor(0xfc9003); 
        engine.add(powerupobject);

		//INITALIZE OTHER VARS
		enemy1Hit = false;
        enemy2Hit = false;
		hitNumberEnemy1 = 0;
        hitNumberEnemy2 = 0;

		// PRINT LEVEL TO USER TERMINAL
		if      (difficulty == 1) { System.out.printf("Difficulty: Easy\n\n"); } 
		else if (difficulty == 2) { System.out.printf("Difficulty: Medium\n\n"); } 
		else if (difficulty == 3) { System.out.printf("Difficulty: Hard\n\n"); }

        
    }

    public void tick() {
        // MOVE PROJECTILE		
        if (enemy1 != null && enemy2 != null) {
            if (projectile != null) { HandleCollision.checkProjectileCollision(projectile, enemy1, enemy2, this);}
            if (player != null) { HandleCollision.checkPlayerCollision(player, enemy1, enemy2, engine); }
        }
    }

    public void keyPressed(int keycode) { 
		// MOVE PLAYER
        if      (keycode == 40) { player.setCenter(player.getX(), player.getY() + 5); } 
		else if (keycode == 38) { player.setCenter(player.getX(), player.getY() - 5); } 
		else if (keycode == 37) { player.setCenter(player.getX() - 5, player.getY()); } 
		else if (keycode == 39) { player.setCenter(player.getX() + 5, player.getY()); } 

		//MOVE TARGET
		else if (keycode == 87) { target.setCenter(target.getX(), target.getY() - 5); } 
		else if (keycode == 65) { target.setCenter(target.getX() - 5, target.getY()); } 
		else if (keycode == 83) { target.setCenter(target.getX(), target.getY() + 5); } 
		else if (keycode == 68) { target.setCenter(target.getX() + 5, target.getY()); }

        // FIRE PROJECTILE
        if (keycode == 32) { if (!projectile.isProjectileFired()) {
			projectile.fireProjectile(target.getX(), target.getY());
			resetCollisionFlags(); }
		}
    }






	// OTHER FUNCTIONS
	public PEEngine getEngine() { return this.engine;}
	public int getDifficulty()  { return this.difficulty; }
	private void resetCollisionFlags() { enemy1Hit = false; enemy2Hit = false;}
	public MyGame() {}
    public void collisionDetected(List<PEWorldObject> worldObjects) {}

}
