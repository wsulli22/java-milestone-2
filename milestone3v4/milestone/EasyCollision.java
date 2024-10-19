import edu.nd.cse.paradigms.*;

public class EasyCollision extends HandleCollision {
    protected static boolean shouldRemoveEnemy(int hitCount, int difficulty) {
        return (difficulty == 1 && hitCount == 1);}
}
