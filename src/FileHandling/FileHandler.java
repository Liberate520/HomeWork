package src.FileHandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import src.FamilyTree.FamilyTree;

public class FileHandler implements Writer {

    private String path = "src/FileHandling/Saved_tree.txt";

    @Override
    public Object read() throws ClassNotFoundException, IOException {
        try (ObjectInputStream inptree = new ObjectInputStream(
            new FileInputStream(path))) {
            FamilyTree tree = (FamilyTree)inptree.readObject();
            return tree;
            }
        catch (Exception e) {
            e.printStackTrace();
            return null;
            }
        }    
    

    @Override
    public void write (Serializable serial) throws FileNotFoundException, IOException{
        try (ObjectOutputStream outtree = new ObjectOutputStream(new FileOutputStream(path))) {
            outtree.writeObject(serial);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
