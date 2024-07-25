package model.serice;

import model.builder.PersonBuilder;
import model.familytree.FamilyTree;
import model.io.FamilyTreeIO;
import model.io.FamilyTreeFileIO;
import model.persons.Gender;
import model.persons.Person;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Service {
    private FamilyTree<Person> familyTree;
    private PersonBuilder personBuilder;
    private FamilyTreeFileIO familyTreeFileIO;

    public Service() {
        familyTree = new FamilyTree<>();
        personBuilder = new PersonBuilder();
        familyTreeFileIO = new FamilyTreeFileIO();
    }

    public void addPerson(String name, String gender, String birthDay) {
        Person person = personBuilder.build();
        person.setName(name);
        setGender(gender, person);
        person.setBirthDay(LocalDate.parse(birthDay));
        familyTree.add(person);
        familyTree.add(person);
    }

    private void setGender(String gender, Person person) {
        if (gender.equalsIgnoreCase("М")) {
            person.setGender(Gender.MALE);
        } else if (gender.equalsIgnoreCase("Ж")) {
            person.setGender(Gender.FEMALE);
        }
    }

    public String findByName(String name) {
        StringBuilder sb = new StringBuilder();
        List<Person> persons = familyTree.getByName(name);
        for (Person person : persons) {
            sb.append(person.toString()).append("\n");
        }
        return sb.toString();
    }

    public String getInfoTree() {
        return familyTree.getInfoTree();
    }

    public List<Integer> foundPersonId(String name) {
        List<Person> foundPersons = familyTree.getByName(name);
        List<Integer> foundPersonId = new ArrayList<>();
        for (Person person : foundPersons) {
            foundPersonId.add(person.getId());
        }
        return foundPersonId;
    }

    public void removePerson(int id) {
        familyTree.remove(id);
    }

    public void sortById() {
        familyTree.sortById();
    }

    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void save() {
        familyTreeFileIO.save(familyTree);
    }

    public void read() {
        if (familyTreeFileIO.read() != null) {
            familyTree = (FamilyTree) familyTreeFileIO.read();
        }
    }
}
