package model.family_tree;

import model.builder.Human;

import java.util.List;

public class FamilyTreeManagerImpl implements FamilyTreeManager {
    private FamilyTree<Human> familyTree;

    public FamilyTreeManagerImpl(FamilyTree<Human> familyTree) {
        this.familyTree = familyTree;
    }

    @Override
    public boolean addHuman(Human human) {
        return familyTree.add(human);
    }

    @Override
    public boolean setWedding(Human human1, Human human2) {
        return familyTree.setWedding(human1, human2);
    }

    @Override
    public boolean setDivorce(Human human1, Human human2) {
        return familyTree.setDivorce(human1, human2);
    }

    @Override
    public List<Human> getSiblings(Human human) {
        return familyTree.getSiblings(human.getId());
    }

    @Override
    public List<Human> getByName(String name) {
        return familyTree.getByName(name);
    }

    @Override
    public String getFamilyTreeInfo() {
        return familyTree.getInfo();
    }
}
