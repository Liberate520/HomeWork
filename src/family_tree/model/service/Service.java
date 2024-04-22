package family_tree.model.service;

import family_tree.model.person.Gender;
import family_tree.model.person.Human;
import family_tree.model.tree.FamilyTree;
import family_tree.model.writer.FileHandler;
import family_tree.model.writer.Writable;

import javax.swing.tree.TreeNode;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Service implements Writable {
    private long genId;
    private FamilyTree familyTree;;

    public Service(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    public Service() {
        this.familyTree = new FamilyTree();
    }

    public boolean addSubjectToFamilyTree(String name, LocalDate dob, Gender gender) {
        Human human = new Human(name, dob, gender);
        human.setId(genId++);
        familyTree.addPersonToFamily(human);
        return true;
    }


    public boolean addSubjectToFamilyTree(String name,
                                          LocalDate dob, LocalDate dod,
                                          Gender gender, Human father, Human mother) {
        Human human = new Human(name, dob, dod, gender, father, mother);
        human.setId(genId++);
        familyTree.addPersonToFamily(human);
        return true;
    }

    public boolean addSubjectToFamilyTree(String name,
                                          LocalDate dob, Gender gender, Human father, Human mother) {
        Human human = new Human(name, dob, gender, father, mother);
        human.setId(genId++);
        familyTree.addPersonToFamily(human);
        return true;
    }

    public boolean addSubjectToFamilyTree(Human human) {
        human.setId(genId++);
        familyTree.addPersonToFamily(human);
        return true;
    }


    public void addSubjectToFamilyTree(String name,
                                       LocalDate dob, LocalDate dod,
                                       Gender gender) {
        Human human = new Human(name, dob, dod, gender);
        human.setId(genId++);
        familyTree.addPersonToFamily(human);
    }

    public void setParentsForSubject(String nameForSearching, Human parent) {
        if (findByName(nameForSearching) != null) {
            findByName(nameForSearching).setParent(parent);
        }
    }

    public Human findByName(String nameForSearching) {
        Human subject = (Human) familyTree.findUnitByName(nameForSearching);
        if (subject != null) return subject;
        System.out.println("Subject with name: " + nameForSearching + " is not found");
        return null;
    }

    public Human findByDateOfBirth(LocalDate dob) {
        Human subject = (Human) familyTree.findHumanByDateOfBirth(dob);
        if (subject != null) return subject;
        System.out.println("Subject with this date of birth: " + dob + " is not found");
        return null;
    }

    public ArrayList<Human> sortByAge() {
        return familyTree.sortByAge();
    }

    public ArrayList<Human> sortByDateOfBirth() {
        return familyTree.sortByDateOfBirth();
    }

    public ArrayList<Human> sortByName() {
        return familyTree.sortByName();
    }


    public boolean writeTreeAsByteCode() {
        return FileHandler.getFileHandler()
                .writeTreeAsByteCode(familyTree);
    }

    @Override
    public boolean writeTreeAsByteCode(Serializable outputObject) { //заглушка, нарушаящая 4 принцип SOLID
        return false;
    }

    public boolean writeSubjectAsByteCode(Serializable outputObject) {
        return FileHandler.getFileHandler()
                .writeSubjectAsByteCode(outputObject);
    }

    public FamilyTree readTreeFromByteCodeFile() {
        return FileHandler.getFileHandler()
                .readTreeFromByteCodeFile();
    }

    public Human readSubjectFromByteCodeFile() {
        return (Human) FileHandler.getFileHandler()
                .readSubjectFromByteCodeFile();
    }

    public String getFilePathForTree() {
        return FileHandler.getFileHandler()
                .getFilePathForTree();
    }

    public void setFilePathForTree(String filePathForTree) {
        FileHandler.getFileHandler()
                .setFilePathForTree(filePathForTree);
    }

    public ArrayList<String> getListOfNamesFromFamilyTree() {
        return getFamilyTree().getListOfNames();
    }

    public ArrayList<String> getListOfNamesFromInputListOfSubjects(ArrayList<Human> inputList) {
        return familyTree.getListOfNamesFromInputList(inputList);
    }

    public FamilyTree getFamilyTree() {
        return familyTree;
    }
    public void setFamilyTree(FamilyTree tree) {
        this.familyTree = tree;
    }


}

