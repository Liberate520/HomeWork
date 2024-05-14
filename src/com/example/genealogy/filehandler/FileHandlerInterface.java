package com.example.genealogy.filehandler;
import java.io.*;

import com.example.genealogy.model.GenealogyTree;

public class FileHandlerInterface {

    public void saveTree(GenealogyTree genealogyTree, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(genealogyTree);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public GenealogyTree loadTree(String filename) {
        GenealogyTree genealogyTree = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            genealogyTree = (GenealogyTree) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return genealogyTree;
    }
}
