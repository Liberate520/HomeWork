package src.model;

import java.time.LocalDate;

public class Model {

    private FamilyTree<Person> family;
    private Person person;

    public Model() {
        family = new FamilyTree<>();

    }

    public void addPerson(String name, Gender gender, LocalDate dateB) {
        Person person = new Person(name, null, null, gender, dateB, null, null, null);
        family.addPerson(person);
    }

    public void sortByName() {
        family.sortByName();
    }

    public void sortByAge() {
        family.sortByAge();
    }

    private void childAddition(Person person) {
        if (person.getFather() != null) {
            person.getFather().setChild(person);
        }
        
        if (person.getMother() != null) {
            person.getMother().setChild(person);
        }
    }

    public void kinship(String familyMembers) {
        //System.out.println(familyMembers);
        Person child = null;
        String[] fM = familyMembers.split(" ");
        // System.out.println("da");
        // System.out.println(fM[0]);
        for (Person person : family) {
            if (person.getName().equals(fM[0])) {
                child = person;
                // System.out.println("da1");
            }
        }
        for (Person person : family) {
            if (person.getName().equals(fM[1])) {
                child.setFather(person);
            }
        }

        for (Person person : family) {
            System.out.println(fM[2]);
            if (person.getName().equals(fM[2])) {
                child.setMother(person);
                System.out.println("da");
            }
        }

        childAddition(child);
    }

    public String prinrtListInfo() {
        return family.printList();
    }

    public void getFamilyTreeList() {
        family.getFamilyTree();
    }

    public void printList() {
        StringBuilder fTree = new StringBuilder();
        for (Person person : family) {
            fTree.append(person.getPersCard(person));
        }
        System.out.println(fTree.toString());
    }

}
