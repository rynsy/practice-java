/*
    From Java Concurrency In Practice, with some changes
    to make the class thread-safe.

    @author Ryan Lindsey
   */
import java.util.concurrent.atomic.AtomicInteger;

public class NumberRange {
    // INVARIANT: upper >= lower
    private final AtomicInteger lower = new AtomicInteger(0);
    private final AtomicInteger upper = new AtomicInteger(0);

    /*
        Synchronized, since data is being modified.
       */
    public synchronized void setLower(int i) {
        if (i > upper.get())
            throw new IllegalArgumentException(
                    "can't set lower to " + i + " > upper");
        lower.set(i);
    }
    
    /*
        Synchronized, since data is being modified.
       */
    public synchronized void setUpper(int i) {
        if (i < lower.get())
            throw new IllegalArgumentException(
                    "can't set upper to " + i + " < lower");
        upper.set(i);
    }
    
    /*
        Synchronized, in case one of the members is modified
        in the middle of this functions return expression.
       */
    public synchronized boolean isInRange(int i) {
        return (i >= lower.get() && i <= upper.get());
    }
}
