package ru.gb.family_tree.model.service;

import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.tools.writer.FileHandler;

import java.time.LocalDate;

public class Service {
    private FamilyTree<Human> tree;
    private FileHandler<Human> fileHandler = new FileHandler();

    public Service() {
        tree = new FamilyTree<>();
    }
//        public Service(String path){
//        tree = fileHandler.read(path);
//    }
    public boolean read(String path) {
        FamilyTree<Human> treeRead = new FamilyTree<Human>();
        treeRead = fileHandler.read(path);
        if (treeRead.equals(null)) {
            return false;
        }
        tree = treeRead;
        return true;
    }

    public boolean write(String path) {
        return fileHandler.write(tree, path);
    }


    public boolean addMember(String name, Gender gender, String date) {
        Human human = new Human(name, gender, date);
        tree.addMember(human);
        return true;
    }


    public void setDeathDate(int personId, LocalDate dod) {
        Human human = tree.findById(personId);
        human.setDod(dod);
    }


    public void setMother(int personId, int motherId) {
        Human human = tree.findById(personId);
        human.setMother(tree.findById(motherId));
    }


    public void setFather(int personId, int fatherId) {
        Human human = tree.findById(personId);
        human.setFather(tree.findById(fatherId));
    }


    public boolean checkById(int id) {
        return tree.checkById(id);
    }


    public String getAboutFamily() {
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

//-----------------------------------------------------------
