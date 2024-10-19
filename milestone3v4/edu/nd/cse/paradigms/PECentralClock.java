package edu.nd.cse.paradigms;
import java.util.Timer;
import java.util.TimerTask;

//public class PECentralClock
public class PECentralClock extends TimerTask {
    private PEEngine engine;
    private Timer timer;

    //public PECentralClock(PEEngine engine, long rate)
    public PECentralClock(PEEngine engine, long rate) {
        this.timer = new Timer(true);
        this.engine = engine;
        timer.scheduleAtFixedRate(this, 0, rate);
    }

    //public void run()
    @Override public void run() { engine.tick(); }
}
