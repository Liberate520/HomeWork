package my_fam_tree.service;

import my_fam_tree.model.FamTreeOper;

import java.io.IOException;

public class FamTreeMan {
    private Writer fileHand;

    public FamTreeMan(Writer fileHand){
        this.fileHand = fileHand;
    }

    public void saveFile(String fileName, FamTreeOper<?> familyTree) throws IOException {
        fileHand.saveToFile(fileName, familyTree);
    }

    public FamTreeOper<?> loadFromFile(String fileName) throws IOException, ClassNotFoundException {
        return fileHand.loadFromFile(fileName);
    }
}
