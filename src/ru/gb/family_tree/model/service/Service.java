package ru.gb.family_tree.model.service;

import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.SpouseStatus;
import ru.gb.family_tree.model.tools.writer.Writable;

import java.time.LocalDate;


public class Service {
    private FamilyTree<Human> tree;
    private Writable<FamilyTree<Human>> fileHandler;

    public Service(Writable fileHandler) {
        this.fileHandler = fileHandler;
        tree = new FamilyTree<>();
    }


//    Опция чтения из файла:
//        public Service(String path){
//        tree = fileHandler.read(path);
//    }


    public boolean read(String path) {
        FamilyTree<Human> treeRead = fileHandler.read(path);
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


    public void setParent(int memberId, int parentId) {
        Human human = tree.findById(memberId);
        human.addParent(tree.findById(parentId));
    }


    public void setSpouse(int firstMemberId, int secondMemberId, SpouseStatus spouseStatus) {
        Human human = tree.findById(firstMemberId);
        human.addSpouse(tree.findById(secondMemberId), spouseStatus);
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
