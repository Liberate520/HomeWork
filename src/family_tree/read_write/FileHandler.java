package family_tree.read_write;

import family_tree.family_tree.FamilyTree;

import java.io.*;

public class FileHandler implements Writer {

    private String filePath = "src/family_tree/read_write";

    @Override
    public void write(Serializable serializable) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(tree);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object read()  {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            Object object = objectInputStream.readObject();
            return object;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void setPath(String filePath){
        this.filePath = filePath;
    }
    
}
