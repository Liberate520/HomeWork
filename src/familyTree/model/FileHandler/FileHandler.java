package familyTree.model.FileHandler;

import java.io.*;

public class FileHandler implements Writer {
    private String fileName;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean saveFile(Serializable serializable) {
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(fileName));
            output.writeObject(serializable);
            output.close();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public Object openFile() {
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(fileName));
            return input.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
