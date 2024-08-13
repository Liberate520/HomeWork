package family_tree.Writer;

import family_tree.family_tree_Angelina.FamilyTree;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileHandler implements WriterHandler {

    @Override
    public void saveFamilyTree(FamilyTree familyTree, String filePath) throws Exception {
        try (FileOutputStream fileOut = new FileOutputStream(filePath);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(familyTree);
        }
    }

    @Override
    public FamilyTree loadFamilyTree(String filePath) throws Exception {
        try (FileInputStream fileIn = new FileInputStream(filePath);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            return (FamilyTree) in.readObject();
        }
    }
}

