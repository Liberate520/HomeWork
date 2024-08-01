package familyTree.writer;

import familyTree.familyTree.FamilyTree;
import familyTree.human.People;

import java.io.*;
import java.util.List;

public class FileHandler implements Writer {


    @Override
    public void saveFamilyTree(String nameFile, List<People> tree) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nameFile))) {
            oos.writeObject(tree);
        }
    }

    @Override
    public FamilyTree loadFamilyTree(String nameFile) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nameFile));
        List<People> tree = (List<People>) ois.readObject();
        ois.close();
        FamilyTree loadFamyli = new FamilyTree(tree);
        return loadFamyli;
    }
}
