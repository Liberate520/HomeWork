package my_fam_tree.service;

import my_fam_tree.model.FamTreeOper;
import java.io.IOException;

public interface Writer  {
    void saveToFile(String fileName, FamTreeOper<?> familyTree) throws IOException;
    FamTreeOper<?> loadFromFile(String fileName) throws IOException, ClassNotFoundException;
}
