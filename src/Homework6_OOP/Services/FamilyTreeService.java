package Homework6_OOP.Services;

import Homework6_OOP.FamilyTreeInterface.IFamilyTree;
import Homework6_OOP.Human.Human;
import Homework6_OOP.WritersClasses.FileHandler;

import java.io.Serializable;
import java.util.List;

public class FamilyTreeService implements Serializable {
    private final IFamilyTree<Human> familyTree;
    private final FileHandler fileHandler;

    public FamilyTreeService(IFamilyTree<Human> familyTree, FileHandler fileHandler) {
        this.familyTree = familyTree;
        this.fileHandler = fileHandler;
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

    public boolean createFamilyRelationship(long parentId, long childId) {
        Human parent = familyTree.getById(parentId);
        Human child = familyTree.getById(childId);

        if (parent != null && child != null) {
            familyTree.addParentChildRelation(parent, child);
        }
        return false;
    }

    public boolean setWedding(long id1, long id2) {
        return familyTree.setWedding(id1, id2);
    }

    public String getFamilyTreeInfo() {
        return familyTree.getInfo();
    }

    public boolean saveFamilyTree(String filename) {
        return fileHandler.save((Serializable) familyTree, filename);
    }

    public boolean loadFamilyTree(String filename) {
        IFamilyTree<Human> loadedTree = (IFamilyTree<Human>) fileHandler.load(filename);
        if (loadedTree != null) {
            familyTree.getEntityList().clear();
            familyTree.getEntityList().addAll(loadedTree.getEntityList());
            return true;
        }
        return false;
    }
}
