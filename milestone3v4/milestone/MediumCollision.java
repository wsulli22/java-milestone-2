import edu.nd.cse.paradigms.*;

public class MediumCollision extends HandleCollision {
    protected static boolean shouldRemoveEnemy(int hitCount, int difficulty) {
        return (difficulty == 2 && hitCount == 2);
    }
}
