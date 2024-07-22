package file_handler;

import family.FamilyTree;

import java.io.*;

public class DataHandler implements Writer {
    private FamilyTree tree;
//    private String data;
//    public file_handler.DataHandler(String data){
//        this.data = data;
//    }
    public DataHandler(FamilyTree tree) {
        this.tree = tree;
    }

    public FamilyTree getTree() {
        return tree;
    }

    public void setTree(FamilyTree tree) {
        this.tree = tree;
    }

    public void saveToFile(String fileName) {
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(tree);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String filename) {
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            tree = (FamilyTree) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
