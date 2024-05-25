package PersonsTree;

import Persons.Person;

import java.util.ArrayList;

public class FamilyTree {
    private String familyName;
    private ArrayList<Person> tree;
    //конструкторы
    public FamilyTree (String familyName) {
        this.familyName = familyName;
        tree = new ArrayList<Person>();
    }
    public FamilyTree() {
        this("default");
    }
    //методы
    public String getAllFamily() {
        String out = "";
        for (Person somePers : tree) {
            out += somePers;
        }
        return out;
    }
    public String getFullPerson (String name) {
        for (Person somePers : tree) {
            if (somePers.getName() == name)
                return somePers.toString();
        }
        return "";
    }
    public String getPersonOnSurname (String name) {
        String out = "";
        for (Person somePers : tree) {
            //System.out.println(somePers.getName().split(" ")[0]);
            if (somePers.getName().split(" ")[0].equals(name))
                out += somePers;
        }
        return out;
    }

    public void addPers(Person somePers) {
        this.tree.add(somePers);
    }
}
