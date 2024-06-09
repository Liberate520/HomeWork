package Model;

import Model.FileHandlerFilse.FileHandler;
import Model.OrganismTree.PersonsTree.FamilyTree;
import Model.Organisms.Mammals.Persons.Enums.Gender;
import Model.Organisms.Mammals.Persons.Person;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;

public class Service implements Serializable {
    private FamilyTree<Person> familyTree;
    private FileHandler fileHandler;
    //при желании путь переноситься в конструктор
    private String path = "homeWork.out";

    //конструктор
    public Service() {
        familyTree = new FamilyTree();
        fileHandler = new FileHandler();
    }

    //методы

    public void addPerson(String name, Gender gender) {
        Person person = new Person(name, gender);
        familyTree.addPers(person);
    }

    public void addParent(int index, int indexParent) {
        familyTree.getByIndex(index).addParent(familyTree.getByIndex(indexParent));
    }

    public void addChield(int index, int indexChield) {
        familyTree.getByIndex(index).addParent(familyTree.getByIndex(indexChield));
    }

    public void getAllFamily() {
        System.out.println(familyTree.getAllFamily());
    }

    public void getFullPerson(int index) {
        if (index < familyTree.size())
            System.out.println(familyTree.getFullPerson(index).toString());
        else
            System.out.println("Такого индекса не существует");
    }

    public void getPersonOnSurname(String name) {
        System.out.println(familyTree.getPersonOnSurname(name).toString());
    }

    public void sortedByName() {
        familyTree.sortByName();
    }

    public void sortByBirthday() {
        familyTree.sortByBirthday();
    }

    public void getFullFamily() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Person person : familyTree)
            stringBuilder.append(person);
        System.out.println(stringBuilder);
    }

    public void addBirthday(LocalDate birthday, int index) {
        familyTree.get(index).addBirthday(birthday);
    }

    public void addDeathDate(LocalDate deathDate, int index) {
        familyTree.get(index).addBirthday(deathDate);
    }

    public int size() {
        return familyTree.size();
    }

    public Person getByIndex(int index) {
        return familyTree.getByIndex(index);
    }

    public HashMap<Integer, String> getAllIndices() {
        return familyTree.getAllIndices();
    }

    //Сериализация

    public void save() {
        fileHandler.save(familyTree, path);
    }

    public void load() {
        fileHandler.load(path);
    }

}