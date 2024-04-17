package family_tree.model.writer;
import java.io.*;

import family_tree.model.family_tree.FamilyTree;
import family_tree.model.human.Human;

public class FileHandler implements Writable{
    @Override
public boolean save(Serializable serializable, String filePath) {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
        oos.writeObject(serializable);
        return true;
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    }
}

    @SuppressWarnings("unchecked")  
    @Override
    public FamilyTree<Human> read(String filePath) { 
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (FamilyTree<Human>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}