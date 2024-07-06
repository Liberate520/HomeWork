package family_tree.creators;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public class IDGenerator implements Serializable {
    private static final AtomicInteger counter = new AtomicInteger();

    public static int generateID() {
        return counter.incrementAndGet();
    }
}
