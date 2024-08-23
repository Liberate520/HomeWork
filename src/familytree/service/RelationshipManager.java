package familytree.service;

import familytree.model.FamilyTree;
import familytree.model.Person;

public class RelationshipManager implements RelationshipManagerInterface{
    private FamilyTree<Person> familyTree;

    public RelationshipManager(FamilyTree<Person> familyTree) {
        this.familyTree = familyTree;
    }

    public void updateFamilyTree(FamilyTree<Person> familyTree) {
        this.familyTree = familyTree;
    }

    @Override
    public void addParentChildRelationship(String parentFamilyName, String parentFirstName, String parentFatherName,
                                           String childFamilyName, String childFirstName, String childFatherName) {
        familyTree.addParentChildRelationship(parentFamilyName, parentFirstName, parentFatherName,
                childFamilyName, childFirstName, childFatherName);
    }
}