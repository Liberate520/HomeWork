package model.writer;

import java.io.*;

public class FileHandler implements Writer {
    private final String filePath = "src/model/writer/family_tree.out";

    @Override
    public void save(Serializable serializable) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(serializable);
        }
    }

    @Override
    public Object deserialize() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return ois.readObject();
        }
    }

    public boolean isFileExists() {
        File file = new File(filePath);
        return file.exists() && file.isFile();
    }
}
