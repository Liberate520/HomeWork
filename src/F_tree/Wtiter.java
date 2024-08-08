package F_tree;

public interface Wtiter {
    void save(FamilyTree familyTree, String fileName);
    FamilyTree load(String fileName);
}
