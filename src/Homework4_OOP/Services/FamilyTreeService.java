package Homework4_OOP.Services;

import Homework4_OOP.FamilyTrees.FamilyTree;
import Homework4_OOP.Human.Human;
import Homework4_OOP.WritersClasses.FileHandler;

import java.io.Serializable;
import java.util.List;

public class FamilyTreeService implements Serializable {
    private final FamilyTree<Human> familyTree;
    private final FileHandler fileHandler;

    public FamilyTreeService() {
        this.familyTree = new FamilyTree<>();
        this.fileHandler = new FileHandler();
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

    public void createFamilyRelationship(long parentId, long childId) {
        Human parent = familyTree.getById(parentId);
        Human child = familyTree.getById(childId);

        if (parent != null && child != null) {
            child.addParent(parent);
            parent.addChild(child);
        }
    }

    public boolean setWedding(long id1, long id2) {
        return familyTree.setWedding(id1, id2);
    }

    public String getFamilyTreeInfo() {
        return familyTree.getInfo();
    }

    public boolean saveFamilyTree(String filename) {
        return fileHandler.save(familyTree, filename);
    }

    public boolean loadFamilyTree(String filename) {
        FamilyTree<Human> loadedTree = (FamilyTree<Human>) fileHandler.read(filename);
        if (loadedTree != null) {
            familyTree.getEntityList().clear(); // Очищаем текущее дерево
            familyTree.getEntityList().addAll(loadedTree.getEntityList()); // Загружаем новое дерево
            return true;
        }
        return false;
    }
}
