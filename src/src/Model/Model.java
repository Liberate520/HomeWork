package src.model;

import java.time.LocalDate;


public class Model {

    private FamilyTree<Person> family;
    

    public Model() {
        family = new FamilyTree<>();

    }

    public Model(FamilyTree<Person> family) {
        this.family = family;

    }


    public boolean addPerson(String name, Gender gender, LocalDate dateB) {
        Person person = new Person(name, null, null, gender, dateB, null, null, null);
        return family.addPerson(person);
    }

    public boolean sortByName() {
       return family.sortByName();
    }

    public boolean sortByAge() {
        return family.sortByAge();
    }

    private void childAddition(Person person) {
        if (person.getFather() != null) {
            person.getFather().setChild(person);
        }
        
        if (person.getMother() != null) {
            person.getMother().setChild(person);
        }
    }

    public boolean kinship(String familyMembers) {
        Person child = null;
        String[] fM = familyMembers.split(" ");
        for (Person person : family) {
            if (person.getName().equals(fM[0])) {
                child = person;
            
            }
        }
        for (Person person : family) {
            if (person.getName().equals(fM[1])) {
                child.setFather(person);
            }
        }

        for (Person person : family) {
            if (person.getName().equals(fM[2])) {
                child.setMother(person);
            
            }
        }

        childAddition(child);
        return true;
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
