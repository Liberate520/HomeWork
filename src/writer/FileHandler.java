package writer;

import java.io.*;


public class FileHandler implements Writable {

    public void writeExternal(Serializable serializable, String FilePath) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FilePath));
        out.writeObject(serializable);
        out.close();

    }

    public Object readExternal(String FilePath) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(FilePath));
        return in.readObject();
    }


}
