package presenter;

import model.FamilyTree;
import model.human.Gender;
import model.human.Person;
import model.writer.FileHandler;
import view.ConsoleUI;

import java.time.LocalDate;
import java.util.List;

public class Presenter {
    private FamilyTree<Person> familyTree;
    private ConsoleUI consoleUI;

    public Presenter(FamilyTree<Person> familyTree, ConsoleUI consoleUI) {
        this.familyTree = familyTree;
        this.consoleUI = consoleUI;
    }

    public void addPerson(String name, int age, Gender gender, LocalDate birthDate) {
        Person person = new Person(name, age, gender);
        person.setBirthDate(birthDate);
        familyTree.addElement(name,person);
    }

    public Person getPerson(String name) {
        return familyTree.getElement(name);
    }

    public List<Person> getChildren(String name) {
        Person parent = familyTree.getElement(name);
        if (parent != null) {
            return parent.getChildren();
        }

        return null;
    }

    public List<Person> sortByName() {
        return familyTree.personSortedByName();
    }

    public List<Person> sortByAge() {
        return familyTree.personSortedByBirthDay();
    }

    public boolean save(String filePath) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.setPath(filePath);

        return fileHandler.save(familyTree);
    }

    public boolean load(String filePath) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.setPath(filePath);
        FamilyTree<Person> loadedTree = (FamilyTree<Person>) fileHandler.read();
        if (loadedTree != null) {
            this.familyTree = loadedTree;

            return true;
        }
        return false;
    }
}
