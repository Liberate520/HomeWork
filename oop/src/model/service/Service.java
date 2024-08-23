package model.service;

import model.family_tree.FamilyTree;
import model.family_tree.FamilyTreeItem;
import model.man.Gender;
import model.man.Man;
import model.writer.Saving;

import java.time.LocalDate;
import java.util.List;

public class Service {
    private FamilyTree<Man> myFamilyTree;
    Saving save;

    public Service() {
        myFamilyTree = new FamilyTree<>();
        save = new Saving();
    }

    public void addLivingItem(String name, Gender gender, LocalDate birthDate) {
        Man man = new Man(name, gender, birthDate);
        myFamilyTree.addToFamilyTree(man);
    }

    public void addDeathItem(String name, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        Man man = new Man(name, gender, birthDate, deathDate);
        myFamilyTree.addToFamilyTree(man);
    }

    public void addItemWithParent(String name, Gender gender, LocalDate birthDate, long id1, long id2) {
        Man mother = myFamilyTree.getById(id1);
        Man father = myFamilyTree.getById(id2);
        Man man = new Man(name, gender, birthDate, mother, father);
        myFamilyTree.addToFamilyTree(man);
    }

    public String getInfoManForId(long id) {
        Man man = myFamilyTree.getById(id);
        return man.getInfo();
    }

    public boolean addChildById(long id1, long id2) {
        Man parent = myFamilyTree.getById(id1);
        Man child = myFamilyTree.getById(id2);
        return parent.addChild(child);
    }

    public boolean addParentById(long id1, long id2) {
        Man child = myFamilyTree.getById(id1);
        Man parent = myFamilyTree.getById(id2);
        if (parent.getGender().equals(Gender.Male)) {
            return child.addFather(parent);
        } else {
            return child.addMother(parent);
        }
    }

    public boolean removeById(long id) {
        return myFamilyTree.remove(id);
    }

    public List<Man> getParentById(long id) {
        Man child = myFamilyTree.getById(id);
        return child.getParents();
    }

    public List<Man> getChildrensById(long id) {
        Man parent = myFamilyTree.getById(id);
        return parent.getChildrens();
    }

    public List<Man> getByName(String name) {
        return myFamilyTree.getByName(name);
    }

    public boolean setWeddingById(long id, long id2) {
        Man man1 = myFamilyTree.getById(id);
        Man man2 = myFamilyTree.getById(id2);
        if (man1 != null && man2 != null) {
            return myFamilyTree.setWedding(man1, man2);
        }
        return false;
    }

    public boolean setDivorceById(long id, long id2) {
        Man man1 = myFamilyTree.getById(id);
        Man man2 = myFamilyTree.getById(id2);
        if (man1 != null && man2 != null) {
            return myFamilyTree.setDivorce(man1, man2);
        }
        return false;
    }

    public void sortByName() {
        myFamilyTree.sortByName();
    }

    public void sortByAge() {
        myFamilyTree.sortByAge();
    }

    public String getFamilyTreeInfo() {
        return myFamilyTree.toString();
    }

    public void saveTree() {
        save.saveTree("tree.txt", myFamilyTree);
    }

    public void loadTree() {
        myFamilyTree = save.loadingTree("tree.txt");
    }


}
