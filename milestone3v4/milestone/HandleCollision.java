import edu.nd.cse.paradigms.*;

public class HandleCollision {

    // PROJECTILE - ENEMY COLLISIONS
    public static boolean checkProjectileCollision(Projectile projectile, Enemy1 enemy1, Enemy2 enemy2, MyGame game) {
        boolean hit = false;

        // Retrieve the current difficulty level from the game instance
        int difficulty = game.getDifficulty();

        // COLLISION WITH ENEMY1
        if (!game.enemy1Hit && game.hitNumberEnemy1 < 3 && isColliding(projectile, enemy1)) {
            game.hitNumberEnemy1++; 
            game.enemy1Hit = true;
            setEnemyColor(game.hitNumberEnemy1, enemy1, difficulty); // Pass difficulty here
            projectile.resetProjectile(game.player.getX(), game.player.getY()); 
            hit = true;
        }

        // COLLISION WITH ENEMY2
        if (!game.enemy2Hit && game.hitNumberEnemy2 < 3 && isColliding(projectile, enemy2)) {
            game.hitNumberEnemy2++; 
            game.enemy2Hit = true;
            setEnemyColor(game.hitNumberEnemy2, enemy2, difficulty); // Pass difficulty here
            projectile.resetProjectile(game.player.getX(), game.player.getY()); 
            hit = true;
        }

        // REMOVE ENEMIES AND RETURN
        handleEnemyRemoval(game, enemy1, enemy2); 
        return hit;
    }

    // PLAYER ENEMY COLLISION
    public static boolean checkPlayerCollision(PECircle player, Enemy1 enemy1, Enemy2 enemy2, PEEngine engine) {
        if (isColliding(player, enemy1) || isColliding(player, enemy2)) {
            engine.remove(player); 
            System.out.println("Game Over"); 
            return true;
        } 
        return false;
    }

    // REMOVE ENEMY
    private static void handleEnemyRemoval(MyGame game, Enemy1 enemy1, Enemy2 enemy2) {
        int difficulty = game.getDifficulty();
        if (enemy1 != null && shouldRemoveEnemy(game.hitNumberEnemy1, difficulty)) { 
            game.getEngine().remove(enemy1);
        }
        if (enemy2 != null && shouldRemoveEnemy(game.hitNumberEnemy2, difficulty)) { 
            game.getEngine().remove(enemy2);
        }
    }

    // PROJECTILE - ENEMY1 COLLISION
    private static boolean isColliding(Projectile projectile, Enemy1 enemy) {
        return projectile.getX() >= enemy.getX() - 25 &&
               projectile.getX() <= enemy.getX() + 25 &&
               projectile.getY() >= enemy.getY() - 25 &&
               projectile.getY() <= enemy.getY() + 25;
    }

    // PROJECTILE - ENEMY2 COLLISION
    private static boolean isColliding(Projectile projectile, Enemy2 enemy) {
        return projectile.getX() >= enemy.getX() - 25 &&
               projectile.getX() <= enemy.getX() + 25 &&
               projectile.getY() >= enemy.getY() - 25 &&
               projectile.getY() <= enemy.getY() + 25;
    }

    // ENEMY1 - PLAYER COLLISION
    private static boolean isColliding(PECircle player, Enemy1 enemy) {
        return player.getX() + 20 >= enemy.getX() - 25 &&
               player.getX() - 20 <= enemy.getX() + 25 &&
               player.getY() + 20 >= enemy.getY() - 25 &&
               player.getY() - 20 <= enemy.getY() + 25;
    }

    // ENEMY2 - PLAYER COLLISION
    private static boolean isColliding(PECircle player, Enemy2 enemy) {
        return player.getX() + 20 >= enemy.getX() - 25 &&
               player.getX() - 20 <= enemy.getX() + 25 &&
               player.getY() + 20 >= enemy.getY() - 25 &&
               player.getY() - 20 <= enemy.getY() + 25;
    }

    // UNIVERSAL COLOR & HIT LOGIC
    private static void setEnemyColor(int hitCount, Enemy1 enemy, int difficulty) {
        if (hitCount == 1 && difficulty == 3) { 
            enemy.setColor(0xFFFF00); // YELLOW
        } else if ((hitCount == 2 && difficulty == 3) || (hitCount == 1 && difficulty == 2)) { 
            enemy.setColor(0xd64036); // RED   
        }
    }
    
    private static void setEnemyColor(int hitCount, Enemy2 enemy, int difficulty) {
        if (hitCount == 1 && difficulty == 3) { 
            enemy.setColor(0xFFFF00); // YELLOW
        } else if ((hitCount == 2 && difficulty == 3) || (hitCount == 1 && difficulty == 2)) { 
            enemy.setColor(0xd64036); // RED   
        }
    }

    // CONDITIONAL REMOVAL OF ENEMY
    protected static boolean shouldRemoveEnemy(int hitCount, int difficulty) {
        return (difficulty == 3 && hitCount == 3) ||
               (difficulty == 2 && hitCount == 2) ||
               (difficulty == 1 && hitCount == 1);
    }
}
