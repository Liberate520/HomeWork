package com.example.genealogy.filehandler;
import java.io.*;

import com.example.genealogy.model.GenealogyTreeModel;

public class FileHandler {

    public void saveTree(GenealogyTreeModel genealogyTree, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(genealogyTree);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public GenealogyTreeModel loadTree(String filename) {
        GenealogyTreeModel genealogyTree = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            genealogyTree = (GenealogyTreeModel) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return genealogyTree;
    }
}
