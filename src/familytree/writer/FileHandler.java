package familytree.writer;

import java.io.*;

public class FileHandler implements Writer {
    private String filePath = "src/familytree/writer/tree.txt";

    @Override
    public void save(Serializable serializable) {
        try {
            File file = new File(filePath);
            file.getParentFile().mkdirs();
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
                objectOutputStream.writeObject(serializable);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object read(String path) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                return null;
            }
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
                return objectInputStream.readObject();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Object read() {
        return read(filePath);
    }

    @Override
    public void setPath(String filePath) {
        this.filePath = filePath;
    }
}