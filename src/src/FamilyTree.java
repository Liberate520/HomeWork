package src;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {

    private List<Person> listPersons;

    public FamilyTree() {
        this.listPersons = new ArrayList<>();
    }

    public FamilyTree(List<Person> listPersons) {
        this.listPersons = listPersons;
    }

    public void addPerson(Person person) {
        if (!listPersons.contains(person)) {
            listPersons.add(person);
        }
        parentalAddition(person);
        childAddition(person);
    }

    private void parentalAddition(Person person) {
        if (person.getChildren() != null) {
            for (Person child : person.getChildren()) {
                if (listPersons.contains(child)) {
                    child.getParent(person);
                }
            }
        }
    }

    private void childAddition(Person person) {
        if (person.getFather() != null) {
            person.getFather().setChild(person);
        } else if (person.getMother() != null) {
            person.getMother().setChild(person);
        }
    }

    
    public String printList() {
        StringBuilder fTree = new StringBuilder();
        for (Person person : listPersons) {
            fTree.append(person.getPersCard());
            }
        return fTree.toString();
    }

    // public String toString() {
    //     return printList();
    // }

}
