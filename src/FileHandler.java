import java.io.*;

//Реализация сохранения и загрузки
class FileHandler implements Writer {
    private final String fileName;

    public FileHandler(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void save(Serializable serializable) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(serializable);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object read() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
