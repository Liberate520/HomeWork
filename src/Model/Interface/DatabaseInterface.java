package Model.Interface;

public interface DatabaseInterface {
    FamilyTreeInterface<?> getFamilyTree(String name);
    FamilyTreeInterface<?> createNewFamilyTree(String nameCreature);
}
