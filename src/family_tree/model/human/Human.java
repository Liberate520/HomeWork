package family_tree.model.human;

import family_tree.model.humanTree.ItemHumanTree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Comparable<Human>, ItemHumanTree <Human> {
    private static int idCounter = 0;
    private final int id;
    private final String name;
    private final String surname;
    private final LocalDate dob;
    private final LocalDate dod;
    private final Gender gender;
    private final Human father;
    private final Human mother;
    private final List<Human> children;


    public Human (String name, String surname, LocalDate dob, LocalDate dod, Gender gender, Human father, Human mother) {
        this.id = ++idCounter;
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.dod = dod;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
    }


    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public LocalDate getDob() {
        return dob;
    }
    public Human getFather() {
        return father;
    }
    public Human getMother() {
        return mother;
    }
    public List<Human> getChildren() {
        return children;
    }
    public int getId() { return id; }

    public void addChild(Human child) {
        this.children.add(child);
    }

    @Override
    public String toString() {
        String fatherInfo = (father != null) ? father.getName() + " " + father.getSurname() : "unknown";
        String motherInfo = (mother != null) ? mother.getName() + " " + mother.getSurname() : "unknown";
        String childrenInfo = (children != null && !children.isEmpty()) ?
                children.stream().map(h -> h.getName() + " " + h.getSurname()).reduce((s1, s2) -> s1 + ", " + s2).orElse("")
                : "none";
        if (dod == null) {
            return "ID: " + id + "\nName: " + name + "\nSurname: " + surname + "\nDateOfBirth: " + dob + "\nDateOfDeath: Still Alive" + "\nGender: " + gender + "\nFather: " + fatherInfo + "\nMother: " + motherInfo +
                    "\nChildren: " + childrenInfo + "\n";
        }
        return "ID: " + id + "\nName: " + name + "\nSurname: " + surname + "\nDateOfBirth: " + dob + "\nDateOfDeath: " + dod + "\nGender: " + gender + "\nFather: " + fatherInfo + "\nMother: " + motherInfo +
                "\nChildren: " + childrenInfo + "\n";

    }

    @Override
    public int compareTo(Human anotherHuman) {
        return this.name.compareTo(anotherHuman.name);
    }

}
