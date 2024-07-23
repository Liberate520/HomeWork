package model.handler;
import model.familyTree.FamilyTree;
import model.writer.Writer;
import java.io.*;

public class FileHandler implements Writer {

    @Override
    public void WriteObject(FamilyTree ft, String file_name) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(file_name));
        objectOutputStream.writeObject(ft);
        objectOutputStream.close();
    }

    @Override
    public FamilyTree ReadObject(String file_name) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(file_name));
        FamilyTree ftRestored = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
        return ftRestored;
    }
}
