package fileHandler;

import human.GenealogyTree;
import java.io.*;

public class SaveLoadFile implements Writeable {
    @Override
    public void saveToFile(String fileName, GenealogyTree tree) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(fileName);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        objectOut.writeObject(tree);
        objectOut.close();
        fileOut.close();
    }

    @Override
    public GenealogyTree loadFromFile(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(fileName);
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        GenealogyTree tree = (GenealogyTree) objectIn.readObject();
        objectIn.close();
        fileIn.close();
        return tree;
    }
}