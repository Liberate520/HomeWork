package family_tree.model.saving_data;

import family_tree.model.program_classes.FamilyTreeItem;

import java.io.*;

public class FileHandler<T extends Serializable> implements Writer<Object> {
    private String filePath;

    public FileHandler(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void writeData(Object fTree)  {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream(filePath));
            objectOutputStream.writeObject(fTree);
            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public T readData() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream(filePath));
            T data = (T) objectInputStream.readObject();
            objectInputStream.close();
            return data;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
