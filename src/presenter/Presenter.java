package presenter;

import model.FamilyTree;
import model.human.Gender;
import model.human.Person;
import model.writer.FileLoader;
import model.writer.FileSaver;
import view.ConsoleUI;

import java.time.LocalDate;
import java.util.List;

public class Presenter {
    private FamilyTree<Person> familyTree;
    private FileSaver fileSaver;
    private FileLoader fileLoader;

    public Presenter(FamilyTree<Person> familyTree, FileLoader fileLoader, FileSaver fileSaver) {
        this.familyTree = familyTree;
        this.fileLoader = fileLoader;
        this.fileSaver = fileSaver;
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
        return fileSaver.save(familyTree);
    }

    public boolean load(String filePath) {
        FamilyTree<Person> loadedTree = (FamilyTree<Person>) fileLoader.read();
        if (loadedTree != null) {
            this.familyTree = loadedTree;

            return true;
        }
        return false;
    }
}
