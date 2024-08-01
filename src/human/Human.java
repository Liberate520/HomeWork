package human;

import humanTree.ItemHumanTree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Human implements Serializable, Comparable<Human>, ItemHumanTree {
    private final String name;
    private final String surname;
    private final LocalDate dob;
    private final LocalDate dod;
    private final Gender gender;
    private final Human father;
    private final Human mother;
    private final List<Human> children;

    public Human (String name, String surname, LocalDate dob, LocalDate dod, Gender gender, Human father, Human mother, List<Human> childern) {
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.dod = dod;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.children = childern;
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
            return "Name: " + name + "\nSurname: " + surname + "\nDateOfBirth: " + dob + "\nDateOfDeath: Still Alive" + "\nGender: " + gender + "\nFather: " + fatherInfo + "\nMother: " + motherInfo +
                    "\nChildren: " + childrenInfo + "\n";
        }
        return "Name: " + name + "\nSurname: " + surname + "\nDateOfBirth: " + dob + "\nDateOfDeath: " + dod + "\nGender: " + gender + "\nFather: " + fatherInfo + "\nMother: " + motherInfo +
                "\nChildren: " + childrenInfo + "\n";

    }

    @Override
    public int compareTo(Human anotherStudent) {
        return this.name.compareTo(anotherStudent.name);
    }
}
