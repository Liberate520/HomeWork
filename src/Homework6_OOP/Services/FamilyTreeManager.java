package Homework6_OOP.Services;

import Homework6_OOP.FamilyTreeInterface.IFamilyTree;
import Homework6_OOP.Human.Human;
import java.util.List;

public class FamilyTreeManager {
    private final IFamilyTree<Human> familyTree;

    public FamilyTreeManager(IFamilyTree<Human> familyTree) {
        this.familyTree = familyTree;
    }

    public void addHuman(Human human) {
        familyTree.add(human);
    }

    public List<Human> searchByName(String name) {
        return familyTree.getByName(name);
    }

    public boolean removeHumanById(long id) {
        return familyTree.remove(id);
    }

    public boolean createParentChildRelationship(long parentId, long childId) {
        Human parent = familyTree.getById(parentId);
        Human child = familyTree.getById(childId);

        if (parent != null && child != null) {
            familyTree.addParentChildRelation(parent, child);
            return true;
        }
        return false;
    }

    public boolean createMarriage(long id1, long id2) {
        return familyTree.setWedding(id1, id2);
    }

    public boolean saveFamilyTree(String filename) {
        try {
            familyTree.saveToFile(filename);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean loadFamilyTree(String filename) {
        try {
            familyTree.loadFromFile(filename);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getFamilyTreeInfo() {
        return familyTree.getInfo();
    }
}
