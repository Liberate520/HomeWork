package family_tree.service;

import family_tree.person.BasicUnit;
import family_tree.person.Gender;
import family_tree.person.Human;
import family_tree.tree.FamilyTree;
import family_tree.writer.FileHandler;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Service<T extends BasicUnit> {
    private long genId;
    private FamilyTree familyTree;
    private FileHandler fh;


    public Service(FamilyTree<T> familyTree) {
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
            Human human = new Human(name, dob, dod, gender, (Human) father, (Human) mother);
            human.setId(genId++);
            familyTree.addPersonToFamily(human, generation);
        }
    }

    @SuppressWarnings("unchecked")
    public void addHumanToFamilyTree(int generation, String name,
                                     LocalDate dob, Gender gender, T father, T mother, Class<T> clazz) {
        if (clazz.equals(Human.class)) {
            Human human = new Human(name, dob, gender, (Human) father, (Human) mother);
            human.setId(genId++);
            familyTree.addPersonToFamily(human, generation);
        }

    }

    @SuppressWarnings("unchecked")
    public void addHumanToFamilyTree(int generation, T human) {
        human.setId(genId++);
        familyTree.addPersonToFamily(human, generation);
    }

    @SuppressWarnings("unchecked")

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

    public T findByName(String nameForSearching) {
        return (T) familyTree.findUnitByName(nameForSearching); //??
    }


    @SuppressWarnings("unchecked")
    public FamilyTree<T> getFamilyTree() {
        return familyTree;
    }

    public void initializationFileHandler() {
        fh = new FileHandler(); // ??
    }



    public boolean writeTreeAsByteCode(Serializable outputObject, String fileNameForTree) {
        return fh.writeTreeAsByteCode(outputObject, fileNameForTree);
    }


    public boolean writeUnitAsByteCode(Serializable outputObject, String fileNameForPeople) {
        return fh.writeUnitAsByteCode(outputObject, fileNameForPeople);
    }

    public FamilyTree readTreeFromByteCodeFile(String fileNameForTree) {
        return fh.readTreeFromByteCodeFile(fileNameForTree);
    }


    public T readUnitFromByteCodeFile(String fileNameForPeople) {
        return (T) fh.readUnitFromByteCodeFile(fileNameForPeople); //??
    }


    @SuppressWarnings("unchecked")
    public ArrayList<String> sorting(int request) {
        ArrayList<T> res = switch (request) {
            case (1) -> familyTree.sortByName();
            case (2) -> familyTree.sortByAge();
            default -> familyTree.sortByDateOfBirth();
        };
        return familyTree.getListOfNames(res);
    }
}