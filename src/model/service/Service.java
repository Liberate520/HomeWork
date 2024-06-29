package model.service;

import java.time.LocalDate;

import model.family_tree.FamilyTree;
import model.human.Gender;
import model.human.Human;
import model.human.SpouseStatus;
import model.save_and_load.Writable;


public class Service {
    private FamilyTree<Human> tree;
    private Writable<FamilyTree<Human>> fileHandler;


    public Service(Writable fileHandler){
        this.fileHandler = fileHandler;
        tree = new FamilyTree<>();
    }

    public boolean read(String file) {
        FamilyTree<Human> treeRead = fileHandler.read(file);
        if (treeRead.equals(null)) {
            return false;
        }
        tree = treeRead;
        return true;
    }

    public boolean save(String file) {
        return fileHandler.save(tree, file);
    }





    public boolean addHuman(String name, Gender gender, String date) {
        Human human = new Human(name, gender, date);
        tree.addHuman(human);
        return true;
    }

    public void setDeathDate(int personId, LocalDate deathDate) {
    Human human = tree.findById(personId);
    human.setDeathDate(deathDate);
}

    public void setParent(int humanId, int parentId) {
        Human human = tree.findById(humanId);
        human.addParent(tree.findById(parentId));
    }

    public void setSpouse(int firstHumanId, int secondHumanId, SpouseStatus spouseStatus) {
        Human human = tree.findById(firstHumanId);
        human.addSpouse(tree.findById(secondHumanId), spouseStatus);
    }


    public boolean checkById(int id) {
        return tree.checkById(id);
    }




    public String getFamilyTreeInfo() {
        return tree.toString();
    }



    public String sortTreeByAge() {
        tree.sortByAge();
        return tree.toString();
    }


    public String sortTreeByName() {
        tree.sortByName();
        return tree.toString();
    }
}
