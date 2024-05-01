package homeWork.model.service;

import java.io.Serializable;
import java.time.LocalDate;
import homeWork.model.human.Human;
import homeWork.model.familyTree.FamilyTree;
import homeWork.model.familyTree.TreePrinter;
import homeWork.model.gender.Gender;

public class Service {
    private FamilyTree<Human> tree1;
    private TreePrinter<Human> treePrinter;
    private FileHandler fileHandler;


    public Service() {
        tree1 = new FamilyTree<>();
        this.treePrinter = new TreePrinter<>(tree1);
        fileHandler = new FileHandler();
    }

    public void addHuman(String name, LocalDate dob, LocalDate dod, Gender gender, Human mother, Human father){
        Human human = new Human(name, dob, dod, gender, mother, father);
        tree1.addHuman(human);
    }

    public void addHuman(String name, LocalDate dob, Gender gender, Human mother, Human father){
        addHuman(name, dob, null, gender, mother, father);
    }

    public void addHuman(String name, LocalDate dob, Gender gender){
        addHuman(name, dob, null, gender, null, null);
    }

    public void addHuman(String name, LocalDate dob, LocalDate dod ,Gender gender){
        addHuman(name, dob, dod, gender, null, null);
    }

    public String printTree() {
        return treePrinter.printTree();
    }

    public Human findPerson(String name, LocalDate dob) {
        for (Human human : tree1) {
            if (human.getName().equals(name) && human.getDob().equals(dob)) {
                return human;
            }
        }
        return null;
    }

    public void sortbyName(){
        tree1.sortbyName();
    }

    public void sortbyDate(){
        tree1.sortbyDate();
    }
    public void saveToFile(Serializable serializable, String filename) {
        fileHandler.writeFile(tree1, filename);
    }

    public Object loadFromFile(String filename) {
        return fileHandler.readFile(filename);
    }
    
    @Override
    public String toString() {
        return printTree();
    }
}
