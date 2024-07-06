package family_tree.creators;

import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;

public class IDGenerator implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private static AtomicInteger counter;

    static {
        try {
            FileInputStream fileIn = new FileInputStream("src/family_tree/read_write/serialized_files/counter.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            counter = (AtomicInteger) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            counter = new AtomicInteger();
        }
    }

    public static int generateID() {
        return counter.incrementAndGet();
    }

    public static void saveCounter() {
        try {
            FileOutputStream fileOut = new FileOutputStream("src/family_tree/read_write/serialized_files/counter.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(counter);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
