package src.Model;

import java.time.LocalDate;

public class Model {

    private FamilyTree<Person> family;

    public void addPerson(String name, Gender gender, LocalDate dateB) {
        Person person = new Person(name, name, name, gender, null, null, null, null);
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
        } else if (person.getMother() != null) {
            person.getMother().setChild(person);}}

    public void kinship(String familyMembers) {
        Person child = new Person(null, null, null);
        String[] fM = familyMembers.split("");
        for (Person person : family) {
            if (person.getName() == fM[0]) {
                child = person;
            } else if (person.getName() == fM[1]) {
                child.setFather(person);
            } else if (person.getName() == fM[2]) {
                child.setMother(person);
            }
            
        }
        childAddition(child);  }     

    

    public String prinrtListInfo() {
        return family.printList();
    }

}
