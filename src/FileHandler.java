
    import java.io.*;

    public class FileHandler implements Writeable {

        @Override
        public <T> void writeToFile(T obj, String filename) throws IOException {
            try (FileOutputStream fileOut = new FileOutputStream(filename);
                 ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(obj);
            }
        }

        @Override
        public <T> T readFromFile(String filename) throws IOException, ClassNotFoundException {
            try (FileInputStream fileIn = new FileInputStream(filename);
                 ObjectInputStream in = new ObjectInputStream(fileIn)) {
                return (T) in.readObject();
            }
        }
    }


