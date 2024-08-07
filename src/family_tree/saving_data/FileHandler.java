package family_tree.saving_data;

import family_tree.FamilyTree;

import java.io.*;

public class FileHandler implements Writer {
    private String filePath;

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void writeData(FamilyTree fTree)  {
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
    public FamilyTree readData() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream(filePath));
            FamilyTree data = (FamilyTree) objectInputStream.readObject();
            objectInputStream.close();
            return data;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
