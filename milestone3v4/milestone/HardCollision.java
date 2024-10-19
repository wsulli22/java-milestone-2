import edu.nd.cse.paradigms.*;

public class HardCollision extends HandleCollision {
    protected static boolean shouldRemoveEnemy(int hitCount, int difficulty) {
        return (difficulty == 3 && hitCount == 3);
    }
}
