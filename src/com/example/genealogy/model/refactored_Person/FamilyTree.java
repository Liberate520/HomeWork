package com.example.genealogy.model.refactored_Person;
import java.util.List;

public class FamilyTree {

    private List<IPerson> people;

    public FamilyTree(List<IPerson> people) {
        this.people = people;
    }

    public void printFamilyTree() {
        for (IPerson person : people) {
            System.out.println(person.getName());
            if (person instanceof Parent) {
                Parent parent = (Parent) person;
                for (IPerson child : parent.getChildren()) {
                    System.out.println("    " + child.getName());
                }
            }
        }
    }

}
