package service;

import family_tree.FamilyTree;
import human.Human;

public class Service {
    private FamilyTree<Human> familyTree;

    public Service() {
        this.familyTree = new FamilyTree<>();
    }
}