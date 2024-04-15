package src;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {

    private List<Person> listPersons;

    public FamilyTree() {
        this.listPersons = new ArrayList<>();
    }

    
    public FamilyTree(List<Person> listPersons) {
        this.listPersons = listPersons;
    }
    
    public List<Person> getFamilyTree(){
        return listPersons;
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
            fTree.append(person.getPersCard(person));
            }
        return fTree.toString();
    }

    // public String toString() {
    //     return printList();
    // }

}
