import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileHandler {

    public void serialize(String fileName, Object object) throws IOException {
        File file = new File(fileName);
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(object);
        }
    }

    public Object deserialize(String fileName) throws IOException, ClassNotFoundException {
        File file = new File(fileName);
        try (FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return objectInputStream.readObject();
        }
    }
}
