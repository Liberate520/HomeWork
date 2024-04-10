package model.writer;

import model.tree.FamilyTree;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



public class FileHandler implements Writable {

    private String filePath = "src/model/writer/familyTree.txt";

    @Override
    public boolean saveToFile(FamilyTree familyTree) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(familyTree);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public FamilyTree uploadFromFile () {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            FamilyTree uploadedTree=(FamilyTree) in.readObject();
            return uploadedTree;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }



}
