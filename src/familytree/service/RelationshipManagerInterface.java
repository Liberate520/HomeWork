package familytree.service;
import familytree.model.FamilyTree;
import familytree.model.Person;

public interface RelationshipManagerInterface {
    void addParentChildRelationship(String parentFamilyName, String parentFirstName, String parentFatherName,
                                    String childFamilyName, String childFirstName, String childFatherName);
    void updateFamilyTree(FamilyTree<Person> familyTree);
}
