package Model;

import Model.FileHandlerFilse.FileHandler;
import Model.OrganismTree.PersonsTree.FamilyTree;
import Model.Organisms.Mammals.Persons.Enums.Gender;
import Model.Organisms.Mammals.Persons.Person;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;

public class Service implements Serializable{
    private FamilyTree<Person> familyTree;
    private FileHandler fileHandler;

    //конструктор
    public Service() {
        familyTree = new FamilyTree();
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

    public String getAllFamily() {
        return familyTree.getAllFamily();
    }

    public String getFullPerson(int index) {
        if (index < familyTree.size())
            return familyTree.getFullPerson(index).toString();
        else
            return "Такого индекса не существует";
    }

    public String getPersonOnSurname(String name) {
        return familyTree.getPersonOnSurname(name).toString();
    }

    public void sortedByName() {
        familyTree.sortByName();
    }

    public void sortByBirthday() {
        familyTree.sortByBirthday();
    }

    public String getFullFamily() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Person person : familyTree)
            stringBuilder.append(person);
        return stringBuilder.toString();
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
        fileHandler.save(familyTree);
    }

    public void load() {
        fileHandler = new FileHandler();
        fileHandler.load();
    }

}