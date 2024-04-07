package family_tree.service;

import family_tree.interfaces.Comparable;
import family_tree.interfaces.Writable;
import family_tree.person.Gender;
import family_tree.person.Human;
import family_tree.tree.FamilyTree;
import family_tree.writer.FileHandler;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Service implements Comparable, Writable {
    private long genId;
    private FamilyTree familyTree;
    private FileHandler fh;

    public Service(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    public Service() {
        this.familyTree = new FamilyTree();
    }

    public void addHumanToFamilyTree(int generation, String name, LocalDate dob, Gender gender) {
        Human human = new Human(name, dob, gender);
        human.setId(genId++);
        familyTree.addPersonToFamily(human, generation);
    }

    public void addHumanToFamilyTree(int generation, String name,
                                     LocalDate dob, LocalDate dod,
                                     Gender gender, Human father, Human mother) {
        Human human = new Human(name, dob, dod, gender, father, mother);
        human.setId(genId++);
        familyTree.addPersonToFamily(human, generation);
    }

    public void addHumanToFamilyTree(int generation, String name,
                                     LocalDate dob, Gender gender, Human father, Human mother) {
        Human human = new Human(name, dob, gender, father, mother);
        human.setId(genId++);
        familyTree.addPersonToFamily(human, generation);
    }

    public void addHumanToFamilyTree(int generation, Human human) {
        human.setId(genId++);
        familyTree.addPersonToFamily(human, generation);
    }

    public void addHumanToFamilyTree(int generation, String name,
                                     LocalDate dob, LocalDate dod,
                                     Gender gender) {
        Human human = new Human(name, dob, dod, gender);
        human.setId(genId++);
        familyTree.addPersonToFamily(human, generation);
    }

    public boolean setParentsForHuman(String nameForSearching, Human parent) {
        if (findByName(nameForSearching) != null) {
            if (parent.getGender().equals(Gender.Male)) {
                findByName(nameForSearching).setFather(parent);
                return true;
            }
            findByName(nameForSearching).setMother(parent);
            return true;
        }
        return false;
    }

    public Human findByName(String nameForSearching){
        return familyTree.findHumanByName(nameForSearching);
    }


    public FamilyTree getFamilyTree() {
        return familyTree;
    }
    public void initializationFileHandler(){
        fh = new FileHandler();
    }
    public FileHandler getFileHandler(){
        return fh;
    }
    @Override
    public boolean writeTreeAsByteCode(Serializable outputObject, String fileNameForTree){
        return  fh.writeTreeAsByteCode(outputObject, fileNameForTree);
    }

    @Override
    public boolean writeHumanAsByteCode(Serializable outputObject, String fileNameForPeople) {
        return  fh.writeHumanAsByteCode(outputObject,  fileNameForPeople);
    }

    @Override
    public FamilyTree readTreeFromByteCodeFile(String fileNameForTree) {
        return fh.readTreeFromByteCodeFile(fileNameForTree);
    }

    @Override
    public Human readHumanFromByteCodeFile(String fileNameForPeople) {
        return fh.readHumanFromByteCodeFile(fileNameForPeople);
    }

    @Override
    public ArrayList<String> sortByAge(){
        return familyTree.getListOfNames(familyTree.sortByAge());
    }

    @Override
    public ArrayList<String> sortByName(){
        return familyTree.getListOfNames(familyTree.sortByName());
    }

}
