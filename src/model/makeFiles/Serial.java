package model.makeFiles;

import model.famyilyTree.FamilyTree;

import java.io.*;

public class Serial implements MakeFiles {
    public boolean saveToFile (FamilyTree tree, String filename) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(tree);
            out.close();
            fileOut.close();
            System.out.println("Object serialized and saved to file " + filename);
            return true;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public FamilyTree readFromFile (String filename) {
        FamilyTree tree = null;
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            tree = (FamilyTree) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Object deserialized from file " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tree;
    }
}
