package familytree.model.util;

import java.io.*;
import java.util.List;

public class FileHandler implements Writer, Reader {

    private String filePath="familytree/familyTree.txt";
    @Override
    public void writeToFile(Serializable serializable) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(serializable);
        }  catch (IOException e) {
                 System.out.println("Error writing to file: " + e.getMessage());
             }
    }

    @Override
    public Object readFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            Object object = ois.readObject();
            return (object);
        }  catch (Exception e) {
            System.out.println("Error reading tree from file: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void setPath(String filePath){
        this.filePath=filePath;
    }

}