package family_tree.model;

public interface TreePersistenceService {
    void saveTreeToFile(FamilyTreeModel model, String fileName);
    FamilyTreeModel loadTreeFromFile(String fileName);
}