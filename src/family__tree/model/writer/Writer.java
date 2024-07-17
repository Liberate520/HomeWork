package family__tree.model.writer;

import family__tree.model.family_tree_service.FamilyTreeService;

import java.io.IOException;

public interface Writer {
    void writeToFile(FamilyTreeService familyTreeService, String fileName) throws IOException;
    FamilyTreeService readFromFile(String fileName) throws IOException, ClassNotFoundException;
}
