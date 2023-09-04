import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public interface Job {
    void run();

    String getId();
}

