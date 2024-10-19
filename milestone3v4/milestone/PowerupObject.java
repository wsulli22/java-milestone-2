import edu.nd.cse.paradigms.*;
import java.util.Random;

public class PowerupObject extends PESquare {

    protected boolean shownStatus;
    protected int interval;
    protected int intervalCounter;
    private Random random = new Random();

    public PowerupObject() { 
        super(); 
        shownStatus = false; 
        interval = 100; 
        intervalCounter = 0;
    }

    public void tick() {
        System.out.println(intervalCounter);
        
        intervalCounter++;

        if (intervalCounter == interval) {
            int randomX = random.nextInt(301) + 50; // Random value between 50 and 350
            int randomY = random.nextInt(301) + 50; // Random value between 50 and 350
            if(this != null){this.setCenter(randomX, randomY);}
        } else if (intervalCounter > interval * 2) {
            if(this != null){this.setCenter(-20, -20);}
            intervalCounter = 0;
        }
    } 
} // Add the missing closing brace for the class here
