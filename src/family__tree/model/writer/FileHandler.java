package family__tree.model.writer;

import family__tree.model.family_tree_service.FamilyTreeService;

import java.io.*;

public class FileHandler implements Writer {
    @Override
    public void writeToFile(FamilyTreeService familyTreeService, String fileName) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(familyTreeService);
        }
    }

    @Override
    public FamilyTreeService readFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            return (FamilyTreeService) in.readObject();
        }
    }
}
