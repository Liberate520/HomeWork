package family_tree.service;

import family_tree.person.Gender;
import family_tree.person.Human;
import family_tree.tree.FamilyTree;
import family_tree.writer.FileHandler;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Service<T extends Human> {
    private long genId;
    private FamilyTree familyTree;
    private FileHandler fh;


    public Service(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    @SuppressWarnings("unchecked")
    public Service(Class<T> clazz) {
        this.familyTree = new FamilyTree<>();
    }

    @SuppressWarnings("unchecked")
    public void addHumanToFamilyTree(int generation, String name, LocalDate dob, Gender gender, Class<T> clazz) {
        if (clazz.equals(Human.class)) {
            Human human = new Human(name, dob, gender);
            human.setId(genId++);
            familyTree.addPersonToFamily(human, generation);
        }

    }

    @SuppressWarnings("unchecked")
    public void addHumanToFamilyTree(int generation, String name,
                                     LocalDate dob, LocalDate dod,
                                     Gender gender, T father, T mother, Class<T> clazz) {
        if (clazz.equals(Human.class)) {
            Human human = new Human(name, dob, dod, gender, father, mother);
            human.setId(genId++);
            familyTree.addPersonToFamily(human, generation);
        }
    }

    @SuppressWarnings("unchecked")
    public void addHumanToFamilyTree(int generation, String name,
                                     LocalDate dob, Gender gender, T father, T mother, Class<T> clazz) {
        if (clazz.equals(Human.class)) {
            Human human = new Human(name, dob, gender, father, mother);
            human.setId(genId++);
            familyTree.addPersonToFamily(human, generation);
        }

    }

    @SuppressWarnings("unchecked")
    public void addHumanToFamilyTree(int generation, T human) {
        human.setId(genId++);
        familyTree.addPersonToFamily(human, generation);
    }

    public void addHumanToFamilyTree(int generation, String name,
                                     LocalDate dob, LocalDate dod,
                                     Gender gender, Class<T> clazz) {
        if (clazz.equals(Human.class)) {
            Human human = new Human(name, dob, dod, gender);
            human.setId(genId++);
            familyTree.addPersonToFamily(human, generation);
        }
    }

    public void setParentsForHuman(String nameForSearching, Human parent) {
        if (findByName(nameForSearching) != null) {
            findByName(nameForSearching).setParent(parent);
        }
    }

    public Human findByName(String nameForSearching) {
        return familyTree.findHumanByName(nameForSearching);
    }


    public FamilyTree getFamilyTree() {
        return familyTree;
    }

    public void initializationFileHandler() {
        fh = new FileHandler();
    }

    public FileHandler getFileHandler() {
        return fh;
    }

    public boolean writeTreeAsByteCode(Serializable outputObject, String fileNameForTree) {
        return fh.writeTreeAsByteCode(outputObject, fileNameForTree);
    }


    public boolean writeHumanAsByteCode(Serializable outputObject, String fileNameForPeople) {
        return fh.writeHumanAsByteCode(outputObject, fileNameForPeople);
    }


    public FamilyTree readTreeFromByteCodeFile(String fileNameForTree) {
        return fh.readTreeFromByteCodeFile(fileNameForTree);
    }


    public Human readHumanFromByteCodeFile(String fileNameForPeople) {
        return fh.readHumanFromByteCodeFile(fileNameForPeople);
    }

    public ArrayList<String> getListOfNames(ArrayList<T> peopleList) {
        return familyTree.getListOfNames(peopleList);
    }

    public ArrayList<String> sorting() {
        return getListOfNames(familyTree.sorting());
    }

}
