package human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Human implements Serializable, Comparable<Human> {
    private String name;
    private String surname;
    private LocalDate dob, dod;
    private Gender gender;
    private Human father, mother;
    private List<Human> children;

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

    public void setName(String name) {
        this.name = name;
    }


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getDod() {
        return dod;
    }

    public void setDod(LocalDate dod) {
        this.dod = dod;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
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
